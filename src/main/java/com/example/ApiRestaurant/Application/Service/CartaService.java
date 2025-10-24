package com.example.ApiRestaurant.Application.Service;

import com.example.ApiRestaurant.Web.DTO.CartaResponse;

import java.util.List;

public interface CartaService {
    List<CartaResponse> lista();
    List<CartaResponse> obtenerporTipo(Long idTipo);
    List<CartaResponse> obtenerporCategoria(Long idCategoria);
}
