package com.example.ApiRestaurant.Web.Controller;


import com.example.ApiRestaurant.Application.Service.TipoService;
import com.example.ApiRestaurant.Web.DTO.TipoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo")
@RequiredArgsConstructor
public class TipoController {

    private final TipoService tipoService;

    // Listar todas las categorías
    @GetMapping
    public ResponseEntity<List<TipoResponse>> listar() {
        return ResponseEntity.ok(tipoService.listarRep());
    }
}
