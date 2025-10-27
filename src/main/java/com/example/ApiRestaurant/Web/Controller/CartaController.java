package com.example.ApiRestaurant.Web.Controller;

import com.example.ApiRestaurant.Application.Service.CartaService;
import com.example.ApiRestaurant.Web.DTO.CartaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carta")
@RequiredArgsConstructor
public class CartaController {

    private final CartaService cartaService;

    // Listar toda la carta
    @GetMapping
    public ResponseEntity<List<CartaResponse>> listar() {
        return ResponseEntity.ok(cartaService.lista());
    }

    // Obtener carta por tipo
    @GetMapping("/tipo/{idTipo}")
    public ResponseEntity<List<CartaResponse>> obtenerPorTipo(@PathVariable Long idTipo) {
        return ResponseEntity.ok(cartaService.obtenerporTipo(idTipo));
    }

//    // Obtener carta por categoría
//    @GetMapping("/categoria/{idCategoria}")
//    public ResponseEntity<List<CartaResponse>> obtenerPorCategoria(@PathVariable Long idCategoria) {
//        return ResponseEntity.ok(cartaService.obtenerporCategoria(idCategoria));
//    }
}
