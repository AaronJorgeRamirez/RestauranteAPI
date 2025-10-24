package com.example.ApiRestaurant.Web.Controller;

import com.example.ApiRestaurant.Application.Service.CategoriaService;
import com.example.ApiRestaurant.Web.DTO.CategoriaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    // Listar todas las categorías
    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listar() {
        return ResponseEntity.ok(categoriaService.listar());
    }
}