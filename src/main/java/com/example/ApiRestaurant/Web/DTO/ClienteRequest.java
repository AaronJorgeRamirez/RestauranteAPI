package com.example.ApiRestaurant.Web.DTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class ClienteRequest {
    private String nombre;
    private String apellido;
    private String edad ;
    private String user;
    private String password;
}
