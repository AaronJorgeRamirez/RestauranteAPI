package com.example.ApiRestaurant.Application.Mapper;

import com.example.ApiRestaurant.Domain.Models.Cliente;
import com.example.ApiRestaurant.Web.DTO.LoginRequest;
import com.example.ApiRestaurant.Web.DTO.LoginResponse;

public interface LoginMapper {
    Cliente toEntity(LoginRequest dto);
    LoginResponse toDto(Cliente entity);
}
