package com.example.ApiRestaurant.Web.DTO;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class ClienteRequest {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String user;
    private String password;
}
