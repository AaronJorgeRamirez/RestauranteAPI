package com.example.ApiRestaurant.Web.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TipoResponse {
    private Long idTipo;
    private String tipoPlato;
}
