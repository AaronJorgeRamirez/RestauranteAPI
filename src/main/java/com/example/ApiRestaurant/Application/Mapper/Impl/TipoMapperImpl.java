package com.example.ApiRestaurant.Application.Mapper.Impl;


import com.example.ApiRestaurant.Application.Mapper.TipoMapper;
import com.example.ApiRestaurant.Domain.Models.Tipo;
import com.example.ApiRestaurant.Web.DTO.TipoResponse;
import org.springframework.stereotype.Component;

@Component
public class TipoMapperImpl implements TipoMapper {
    @Override
    public TipoResponse toDto(Tipo entity) {
        return TipoResponse.builder()
                .idTipo(entity.getIdTipo())
                .tipoPlato(entity.getTipoPlato())
                .build();
    }
}
