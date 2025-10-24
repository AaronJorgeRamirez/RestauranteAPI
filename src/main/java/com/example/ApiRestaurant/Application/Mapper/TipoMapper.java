package com.example.ApiRestaurant.Application.Mapper;

import com.example.ApiRestaurant.Domain.Models.Tipo;
import com.example.ApiRestaurant.Web.DTO.TipoResponse;

public interface TipoMapper {
    TipoResponse toDto(Tipo entity);
}
