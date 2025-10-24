package com.example.ApiRestaurant.Application.Service;

import com.example.ApiRestaurant.Web.DTO.ClienteRequest;
import com.example.ApiRestaurant.Web.DTO.ClienteResponse;

public interface ClienteService {
    ClienteResponse crearCliente(ClienteRequest dto);

    ClienteResponse obtenerClientePorId(Long id);
}
