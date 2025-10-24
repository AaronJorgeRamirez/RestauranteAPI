package com.example.ApiRestaurant.Application.Service.Impl;

import com.example.ApiRestaurant.Application.Mapper.CategoriaMapper;
import com.example.ApiRestaurant.Application.Mapper.TipoMapper;
import com.example.ApiRestaurant.Application.Service.TipoService;
import com.example.ApiRestaurant.Domain.Repository.CategoriaRepository;
import com.example.ApiRestaurant.Domain.Repository.TipoRepository;
import com.example.ApiRestaurant.Web.DTO.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class TipoServiceImpl implements TipoService {
    private final TipoMapper tipoMapper;
    private final TipoRepository tipoRep;
    @Override
    public List<TipoResponse> listarRep() {
        return tipoRep.findAll()
                .stream()
                .map(tipoMapper::toDto)
                .toList();
    }
}
