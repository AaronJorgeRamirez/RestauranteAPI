package com.example.ApiRestaurant.Application.Mapper;


import com.example.ApiRestaurant.Domain.Models.Cliente;
import com.example.ApiRestaurant.Web.DTO.ClienteRequest;
import com.example.ApiRestaurant.Web.DTO.ClienteResponse;


public interface ClienteMapper {
    Cliente toEntity(ClienteRequest dto);
    ClienteResponse toDto(Cliente entity);
}
