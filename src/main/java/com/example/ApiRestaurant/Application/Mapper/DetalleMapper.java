package com.example.ApiRestaurant.Application.Mapper;

import com.example.ApiRestaurant.Domain.Models.Carta;
import com.example.ApiRestaurant.Domain.Models.DetallePedido;
import com.example.ApiRestaurant.Domain.Models.Pedido;
import com.example.ApiRestaurant.Web.DTO.DetalleRequest;
import com.example.ApiRestaurant.Web.DTO.DetalleResponse;

public interface DetalleMapper {
    DetallePedido toEntity(DetalleRequest dto, Carta carta, Pedido pedido);
    DetalleResponse toDto(DetallePedido entity);
}
