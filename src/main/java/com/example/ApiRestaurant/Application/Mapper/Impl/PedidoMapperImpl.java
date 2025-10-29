package com.example.ApiRestaurant.Application.Mapper.Impl;

import com.example.ApiRestaurant.Application.Mapper.PedidoMapper;
import com.example.ApiRestaurant.Domain.Models.Cliente;
import com.example.ApiRestaurant.Domain.Models.Estados.EstadoPedido;
import com.example.ApiRestaurant.Domain.Models.Pedido;
import com.example.ApiRestaurant.Web.DTO.PedidoRequest;
import com.example.ApiRestaurant.Web.DTO.PedidoResponse;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PedidoMapperImpl implements PedidoMapper {
    @Override
    public Pedido toEntity(PedidoRequest dto, Cliente cliente) {
        return Pedido.builder()
                .cliente(cliente)
                .numeroCuenta(dto.getNumeroCuenta())
                .fecha(LocalDate.now())
                .estado(EstadoPedido.ABIERTO)
                .build();
    }

    @Override
    public PedidoResponse toDto(Pedido entity) {
        return PedidoResponse.builder()
                .idPedido(entity.getIdPedido())
                .idCliente(entity.getCliente().getId())
                .fecha(entity.getFecha())
                .importeFinal(entity.getImporteFinal())
                .nombre(entity.getCliente().getNombre())
                .apellido(entity.getCliente().getApellido())
                .estado(entity.getEstado().name())
                .numeroPedido(entity.getNumeroPedido())
                .numeroCuenta(entity.getNumeroCuenta())
                .build();
    }
}
