package com.example.ApiRestaurant.Application.Service.Impl;


import com.example.ApiRestaurant.Application.Mapper.CartaMapper;
import com.example.ApiRestaurant.Application.Service.CartaService;
import com.example.ApiRestaurant.Domain.Models.Carta;
import com.example.ApiRestaurant.Domain.Repository.CartaRepository;
import com.example.ApiRestaurant.Domain.Repository.CategoriaRepository;
import com.example.ApiRestaurant.Domain.Repository.TipoRepository;
import com.example.ApiRestaurant.Web.DTO.CartaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CartaServiceImpl implements CartaService {
    private final CartaMapper carMap;
    private final CartaRepository cartaRep;
    private final TipoRepository tipoRep;
    private final CategoriaRepository cateRep;

    @Override
    public List<CartaResponse> lista() {
        return cartaRep.findAll()
                .stream()
                .map(carMap::toDto)
                .toList();
    }

    @Override
    public List<CartaResponse> obtenerporTipo(Long idTipo) {
        List<Carta> carta = cartaRep.findAllByTipo_IdTipo(idTipo);
        return carta.stream()
                .map(carMap::toDto)
                .toList()
                ;

    }

    @Override
    public List<CartaResponse> obtenerporCategoria(Long idCat) {
        List<Carta> carta = cartaRep.findAllByCategoria_idCat(idCat);
        return carta.stream()
                .map(carMap::toDto)
                .toList()
                ;

    }
}
