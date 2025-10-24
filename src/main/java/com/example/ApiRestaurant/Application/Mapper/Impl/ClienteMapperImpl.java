package com.example.ApiRestaurant.Application.Mapper.Impl;


import com.example.ApiRestaurant.Application.Mapper.ClienteMapper;
import com.example.ApiRestaurant.Domain.Models.Cliente;
import com.example.ApiRestaurant.Web.DTO.ClienteRequest;
import com.example.ApiRestaurant.Web.DTO.ClienteResponse;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapperImpl implements ClienteMapper {
    @Override
    public Cliente toEntity(ClienteRequest dto) {
        return Cliente.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .user(dto.getUser())
                .password(dto.getPassword())
                .edad(dto.getEdad())
                .build();
    }

    @Override
    public ClienteResponse toDto(Cliente entity) {
        return ClienteResponse.builder()
                .idCliente(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .user(entity.getUser())
                .password(entity.getPassword())
                .edad(entity.getEdad())
                .build();
    }
}
