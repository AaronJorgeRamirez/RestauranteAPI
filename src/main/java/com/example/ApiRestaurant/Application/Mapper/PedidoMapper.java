package com.example.ApiRestaurant.Application.Mapper;


import com.example.ApiRestaurant.Domain.Models.Cliente;
import com.example.ApiRestaurant.Domain.Models.Pedido;
import com.example.ApiRestaurant.Web.DTO.PedidoRequest;
import com.example.ApiRestaurant.Web.DTO.PedidoResponse;

public interface PedidoMapper {
    Pedido toEntity(PedidoRequest dto, Cliente cliente);
    PedidoResponse toDto(Pedido entity);
}
