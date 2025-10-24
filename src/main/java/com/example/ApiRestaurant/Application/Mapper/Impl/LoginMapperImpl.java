package com.example.ApiRestaurant.Application.Mapper.Impl;


import com.example.ApiRestaurant.Application.Mapper.LoginMapper;
import com.example.ApiRestaurant.Domain.Models.Cliente;
import com.example.ApiRestaurant.Web.DTO.LoginRequest;
import com.example.ApiRestaurant.Web.DTO.LoginResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class LoginMapperImpl implements LoginMapper {
    @Override
    public Cliente toEntity(LoginRequest dto) {
        return Cliente.builder()
                .user(dto.getUser())
                .password(dto.getPassword())
                .build();
    }

    @Override
    public LoginResponse toDto(Cliente entity) {
        return LoginResponse.builder()
                .fecha_ingreso(LocalDate.now())
                .build();
    }
}
