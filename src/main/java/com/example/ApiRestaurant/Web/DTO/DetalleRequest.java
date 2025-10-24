package com.example.ApiRestaurant.Web.DTO;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DetalleRequest {
    private Long idCarta;
    private String nombreCarta;
    private int cantidad;
    private Long idPedido;
}
