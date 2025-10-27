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
    private String nomTipo;
    private int cantidad;
    private BigDecimal subTotal;
}
