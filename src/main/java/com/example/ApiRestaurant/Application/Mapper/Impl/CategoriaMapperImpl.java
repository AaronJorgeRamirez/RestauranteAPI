package com.example.ApiRestaurant.Application.Mapper.Impl;


import com.example.ApiRestaurant.Application.Mapper.CategoriaMapper;
import com.example.ApiRestaurant.Domain.Models.Categoria;
import com.example.ApiRestaurant.Web.DTO.CategoriaResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapperImpl implements CategoriaMapper {
    @Override
    public CategoriaResponse toDto(Categoria entity) {
        return CategoriaResponse.builder()
                .idCat(entity.getIdCat())
                .nomCat(entity.getNomCat())
                .build();
    }
}
