package com.example.ApiRestaurant.Application.Mapper;

import com.example.ApiRestaurant.Domain.Models.Categoria;
import com.example.ApiRestaurant.Web.DTO.CategoriaResponse;

public interface CategoriaMapper {
    CategoriaResponse toDto(Categoria entity);
}
