package com.example.ApiRestaurant.Application.Service.Impl;

import com.example.ApiRestaurant.Application.Mapper.CategoriaMapper;
import com.example.ApiRestaurant.Application.Service.CategoriaService;
import com.example.ApiRestaurant.Domain.Repository.CategoriaRepository;
import com.example.ApiRestaurant.Web.DTO.CategoriaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor


public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaMapper catMapper;
    private final CategoriaRepository catRep;

    @Override
    public List<CategoriaResponse> listar() {
        return catRep.findAll()
                .stream()
                .map(catMapper::toDto)
                .toList();
    }
}
