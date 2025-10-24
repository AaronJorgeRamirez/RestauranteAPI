package com.example.ApiRestaurant.Web.DTO;

import com.example.ApiRestaurant.Domain.Models.DetallePedidoId;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DetalleResponse {
    private String nombreCarta;
    private BigDecimal precio;
    private String imagen;
    private String nomTipo;
    private String nomCategoria;
    private int cantidad;
    private Long idPedido;
    private DetallePedidoId DetallePedidoId;
    private BigDecimal subTotal;
}
