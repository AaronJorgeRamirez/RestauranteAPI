package com.example.ApiRestaurant.Application.Service;

import com.example.ApiRestaurant.Domain.Models.DetallePedidoId;
import com.example.ApiRestaurant.Web.DTO.DetalleRequest;
import com.example.ApiRestaurant.Web.DTO.DetalleResponse;
import java.util.List;

public interface DetallePedidoService {
    DetalleResponse agregarDetalle(Long idCliente, DetalleRequest request);
    List<DetalleResponse> listarDetallesPorPedido(Long id_Pedido);
    void eliminarDetalle(Long idPedido, Long idCarta);
}
