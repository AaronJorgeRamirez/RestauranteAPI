package com.example.ApiRestaurant.Application.Service;

import com.example.ApiRestaurant.Web.DTO.PedidoRequest;
import com.example.ApiRestaurant.Web.DTO.PedidoResponse;
import java.util.List;

public interface PedidoService {
    PedidoResponse crearPedido(PedidoRequest request);
    PedidoResponse obtenerPedidoActivo(Long idCliente);
    PedidoResponse cerrarPedido(Long idCliente);
    List<PedidoResponse> listarPedidosPorCliente(Long idCliente);
    void eliminarPedido(Long id);
}