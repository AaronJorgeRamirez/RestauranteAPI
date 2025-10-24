package com.example.ApiRestaurant.Domain.Models;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido {

    @EmbeddedId
    private DetallePedidoId id;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @MapsId("idCarta")
    @JoinColumn(name = "id_carta")
    private Carta carta;

    private int cantidad;
    private BigDecimal subtotal;
}
