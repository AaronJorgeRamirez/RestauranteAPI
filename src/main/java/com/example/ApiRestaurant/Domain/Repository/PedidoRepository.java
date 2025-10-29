package com.example.ApiRestaurant.Domain.Repository;

import com.example.ApiRestaurant.Domain.Models.Estados.EstadoPedido;
import com.example.ApiRestaurant.Domain.Models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    Optional<Pedido> findByCliente_IdAndEstado(Long idCliente, EstadoPedido Estado);
    List<Pedido> findAllByCliente_Id(Long idCliente);
    Long countByCliente_Id(Long idCliente);
}
