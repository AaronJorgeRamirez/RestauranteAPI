package com.example.ApiRestaurant.Web.Controller;

import com.example.ApiRestaurant.Application.Service.ClienteService;
import com.example.ApiRestaurant.Web.DTO.ClienteRequest;
import com.example.ApiRestaurant.Web.DTO.ClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteResponse> crearCliente(@RequestBody ClienteRequest request) {
        ClienteResponse response = clienteService.crearCliente(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerClientePorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.obtenerClientePorId(id));
    }
}