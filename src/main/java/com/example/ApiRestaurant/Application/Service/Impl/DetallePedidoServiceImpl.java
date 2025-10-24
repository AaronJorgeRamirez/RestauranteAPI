package com.example.ApiRestaurant.Application.Service.Impl;

import com.example.ApiRestaurant.Application.Mapper.DetalleMapper;
import com.example.ApiRestaurant.Application.Service.DetallePedidoService;
import com.example.ApiRestaurant.Domain.Models.*;
import com.example.ApiRestaurant.Domain.Models.Estados.EstadoPedido;
import com.example.ApiRestaurant.Domain.Repository.CartaRepository;
import com.example.ApiRestaurant.Domain.Repository.DetallePedidoRepository;
import com.example.ApiRestaurant.Domain.Repository.PedidoRepository;
import com.example.ApiRestaurant.Web.DTO.DetalleRequest;
import com.example.ApiRestaurant.Web.DTO.DetalleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DetallePedidoServiceImpl implements DetallePedidoService {

    private final PedidoRepository pedidoRepository;
    private final DetallePedidoRepository detalleRepository;
    private final CartaRepository cartaRepository;
    private final DetalleMapper detalleMapper;

    @Transactional
    @Override
    public DetalleResponse agregarDetalle(Long idCliente, DetalleRequest request) {
        // 1️⃣ Obtener pedido abierto o error si no hay
        Pedido pedido = pedidoRepository.findByCliente_IdAndEstado(idCliente, EstadoPedido.ABIERTO)
                .orElseThrow(() -> new RuntimeException("No hay pedido abierto para este cliente."));

        // 2️⃣ Obtener carta
        Carta carta = cartaRepository.findByNombreCarta(request.getNombreCarta())
                .orElseThrow(() -> new RuntimeException("Plato no encontrado: " + request.getNombreCarta()));

        // 3️⃣ Crear ID compuesto
        DetallePedidoId detalleId = new DetallePedidoId(pedido.getIdPedido(), carta.getIdCarta());

        // 4️⃣ Revisar si el detalle ya existe
        DetallePedido detalle = detalleRepository.findById(detalleId).orElse(null);

        if (detalle != null) {
            // ya existe → aumentar cantidad y subtotal
            detalle.setCantidad(detalle.getCantidad() + 1);
            detalle.setSubtotal(carta.getPrecio().multiply(BigDecimal.valueOf(detalle.getCantidad())));
        } else {
            // no existe → crear nuevo detalle
            detalle = DetallePedido.builder()
                    .id(detalleId)
                    .pedido(pedido)
                    .carta(carta)
                    .cantidad(1)
                    .subtotal(carta.getPrecio())
                    .build();
        }

        // 5️⃣ Guardar detalle
        detalleRepository.save(detalle);

        // 6️⃣ Recalcular total del pedido
        BigDecimal total = detalleRepository.findByIdPedido(pedido.getIdPedido())
                .stream()
                .map(DetallePedido::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedido.setImporteFinal(total);
        pedidoRepository.save(pedido);

        // 7️⃣ Retornar DTO
        return detalleMapper.toDto(detalle);
    }

    @Override
    public List<DetalleResponse> listarDetallesPorPedido(Long idPedido) {
        var detalles = detalleRepository.findByIdPedido(idPedido);
        System.out.println("🧩 Detalles encontrados: " + detalles.size());
        detalles.forEach(d -> System.out.println(" - " + d.getCarta().getNombreCarta()));
        return detalles.stream().map(detalleMapper::toDto).toList();
    }
    @Override
    public void eliminarDetalle(Long idPedido, Long idCarta) {
        DetallePedidoId id = new DetallePedidoId(idPedido, idCarta);

        if (detalleRepository.existsById(id)) {
            detalleRepository.deleteById(id);
        } else {
            throw new RuntimeException("El detalle del pedido no existe.");
        }
    }
}