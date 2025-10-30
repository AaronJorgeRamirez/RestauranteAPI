package com.example.ApiRestaurant.Web.Controller;

import com.example.ApiRestaurant.Application.Service.DetallePedidoService;
import com.example.ApiRestaurant.Domain.Models.DetallePedidoId;
import com.example.ApiRestaurant.Web.DTO.DetalleRequest;
import com.example.ApiRestaurant.Web.DTO.DetalleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
@RequiredArgsConstructor

public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    // ➕ Agregar un detalle (producto) a un pedido existente
    @PostMapping("/{idCliente}")
    public ResponseEntity<DetalleResponse> agregarDetalle(
            @PathVariable Long idCliente,
            @RequestBody DetalleRequest request) {

        DetalleResponse response = detallePedidoService.agregarDetalle(idCliente, request);
        return ResponseEntity.ok(response);
    }

    // 📃 Listar todos los detalles de un pedido específico
    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<List<DetalleResponse>> listarDetallesPorPedido(@PathVariable Long idPedido) {
        List<DetalleResponse> detalles = detallePedidoService.listarDetallesPorPedido(idPedido);
        return ResponseEntity.ok(detalles);
    }

    @DeleteMapping("/{idPedido}/{idCarta}")
    public ResponseEntity<Void> eliminarDetalle(
            @PathVariable Long idPedido,
            @PathVariable Long idCarta) {
        detallePedidoService.eliminarDetalle(idPedido, idCarta);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/detalles/multiples/{idCliente}")
    public ResponseEntity<List<DetalleResponse>> agregarMultiplesDetalles(
            @PathVariable Long idCliente,
            @RequestBody List<DetalleRequest> detallesRequest) {
        try {
            List<DetalleResponse> detalles = detallePedidoService.agregarMultiplesDetalles(idCliente, detallesRequest);
            return ResponseEntity.ok(detalles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
