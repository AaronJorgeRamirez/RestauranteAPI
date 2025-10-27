package com.example.ApiRestaurant.Web.DTO;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CartaResponse {
    private Long idCarta;
    private String nombreCarta;
    private BigDecimal precio;
    private String imagen;
    private String nomTipo;
}
