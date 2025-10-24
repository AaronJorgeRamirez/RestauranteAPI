package com.example.ApiRestaurant.Application.Service.Impl;

import com.example.ApiRestaurant.Application.Mapper.PedidoMapper;
import com.example.ApiRestaurant.Domain.Models.*;
import com.example.ApiRestaurant.Domain.Models.Estados.EstadoPedido;
import com.example.ApiRestaurant.Domain.Repository.*;
import com.example.ApiRestaurant.Web.DTO.*;
import com.example.ApiRestaurant.Application.Service.PedidoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoMapper pedidoMapper;

    @Transactional
    @Override
    public PedidoResponse crearPedido(PedidoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Pedido pedido = Pedido.builder()
                .cliente(cliente)
                .fecha(LocalDate.now())
                .importeFinal(BigDecimal.ZERO)
                .estado(EstadoPedido.ABIERTO)
                .build();

        pedidoRepository.save(pedido);
        return pedidoMapper.toDto(pedido);
    }

    @Override
    public PedidoResponse obtenerPedidoActivo(Long idCliente) {
        Pedido pedido = pedidoRepository.findByCliente_IdAndEstado(idCliente, EstadoPedido.ABIERTO)
                .orElseThrow(() -> new RuntimeException("No hay pedidos activos para este cliente."));
        return pedidoMapper.toDto(pedido);
    }

    @Transactional
    @Override
    public PedidoResponse cerrarPedido(Long idCliente) {
        Pedido pedido = pedidoRepository.findByCliente_IdAndEstado(idCliente, EstadoPedido.ABIERTO)
                .orElseThrow(() -> new RuntimeException("No hay pedidos abiertos para este cliente."));

        pedido.setEstado(EstadoPedido.CERRADO);
        pedidoRepository.save(pedido);

        return pedidoMapper.toDto(pedido);
    }

    @Override
    public List<PedidoResponse> listarPedidosPorCliente(Long idCliente) {
        return pedidoRepository.findAllByCliente_Id(idCliente)
                .stream()
                .map(pedidoMapper::toDto)
                .toList();
    }
    @Override
    public void eliminarPedido(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido de id: " + id +"no encontrado");
        }
        pedidoRepository.deleteById(id);
    }
}