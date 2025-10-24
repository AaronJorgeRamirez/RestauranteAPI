package com.example.ApiRestaurant.Web.DTO;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PedidoResponse {
    private Long idPedido;
    private Long idCliente;
    private String nombre;
    private BigDecimal importeFinal;
    private LocalDate fecha;
    private String estado;
}
