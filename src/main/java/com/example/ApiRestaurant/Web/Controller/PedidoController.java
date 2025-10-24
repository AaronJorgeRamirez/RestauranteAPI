package com.example.ApiRestaurant.Web.Controller;

import com.example.ApiRestaurant.Application.Service.PedidoService;
import com.example.ApiRestaurant.Web.DTO.PedidoRequest;
import com.example.ApiRestaurant.Web.DTO.PedidoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    // Crear o continuar pedido
    @PostMapping("/crear")
    public ResponseEntity<PedidoResponse> crearPedido(@RequestBody PedidoRequest request) {
        PedidoResponse response = pedidoService.crearPedido(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cerrar")
    public ResponseEntity<Void> cerrarPedido(@RequestBody Map<String, Long> body) {
        Long idCliente = body.get("idCliente");
        pedidoService.cerrarPedido(idCliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/activo/{id}")
    public ResponseEntity<PedidoResponse> obtenerPedidoActivo(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obtenerPedidoActivo(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PedidoResponse>> listarPedidosPorCliente(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.listarPedidosPorCliente(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }


}