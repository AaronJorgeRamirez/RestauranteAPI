package com.example.ApiRestaurant.Application.Mapper.Impl;

import com.example.ApiRestaurant.Application.Mapper.DetalleMapper;
import com.example.ApiRestaurant.Domain.Models.Carta;
import com.example.ApiRestaurant.Domain.Models.DetallePedido;
import com.example.ApiRestaurant.Domain.Models.Pedido;
import com.example.ApiRestaurant.Web.DTO.DetalleRequest;
import com.example.ApiRestaurant.Web.DTO.DetalleResponse;

import org.springframework.stereotype.Component;

@Component
public class DetalleMapperImpl implements DetalleMapper {
    @Override
    public DetallePedido toEntity(DetalleRequest dto, Carta carta, Pedido pedido) {
        return DetallePedido.builder()
                .cantidad(dto.getCantidad())
                .carta(carta)
                .pedido(pedido)
                .build();
    }

    @Override
    public DetalleResponse toDto(DetallePedido entity) {
        return DetalleResponse.builder()
                .DetallePedidoId(entity.getId())
                .nombreCarta(entity.getCarta().getNombreCarta())
                .precio(entity.getCarta().getPrecio())
                .nomTipo(entity.getCarta().getTipo().getTipoPlato())
                .nomCategoria(entity.getCarta().getCategoria().getNomCat())
                .cantidad(entity.getCantidad())
                .idPedido(entity.getPedido().getIdPedido())
                .imagen(entity.getCarta().getImagen())
                .subTotal(entity.getSubtotal())
                .build();
    }
}
