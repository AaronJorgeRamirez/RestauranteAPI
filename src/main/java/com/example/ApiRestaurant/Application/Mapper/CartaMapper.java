package com.example.ApiRestaurant.Application.Mapper;

import com.example.ApiRestaurant.Domain.Models.Carta;
import com.example.ApiRestaurant.Web.DTO.CartaResponse;

public interface CartaMapper {
    CartaResponse toDto(Carta entity);
}
