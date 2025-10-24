package com.example.ApiRestaurant.Web.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoriaResponse {
    private Long idCat;
    private String nomCat;
}
