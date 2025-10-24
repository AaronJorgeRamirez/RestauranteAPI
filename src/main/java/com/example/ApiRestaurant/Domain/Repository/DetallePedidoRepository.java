package com.example.ApiRestaurant.Domain.Repository;

import com.example.ApiRestaurant.Domain.Models.DetallePedido;
import com.example.ApiRestaurant.Domain.Models.DetallePedidoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido,DetallePedidoId> {
    @Query("SELECT d FROM DetallePedido d WHERE d.pedido.idPedido = :idPedido")
    List<DetallePedido> findByIdPedido(@Param("idPedido") Long idPedido);
}
