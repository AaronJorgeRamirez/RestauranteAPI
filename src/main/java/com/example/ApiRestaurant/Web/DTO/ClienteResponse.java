package com.example.ApiRestaurant.Web.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClienteResponse {
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String edad ;
    private String user;
    private String password;
}
