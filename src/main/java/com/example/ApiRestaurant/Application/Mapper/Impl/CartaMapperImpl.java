package com.example.ApiRestaurant.Application.Mapper.Impl;

import com.example.ApiRestaurant.Application.Mapper.CartaMapper;
import com.example.ApiRestaurant.Domain.Models.Carta;
import com.example.ApiRestaurant.Web.DTO.CartaResponse;
import org.springframework.stereotype.Component;

@Component
public class CartaMapperImpl implements CartaMapper {
    @Override
    public CartaResponse toDto(Carta entity) {
        return CartaResponse.builder()
                .idCarta(entity.getIdCarta())
                .nombreCarta(entity.getNombreCarta())
                .precio(entity.getPrecio())
                .nomTipo(entity.getTipo().getTipoPlato())
                .build();
    }
}
