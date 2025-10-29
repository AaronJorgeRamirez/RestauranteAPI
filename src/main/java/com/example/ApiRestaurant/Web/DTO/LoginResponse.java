package com.example.ApiRestaurant.Web.DTO;

import java.time.LocalDate;
import java.util.Date;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginResponse {
    private String mensaje;
    private LocalDate fecha_ingreso;
    private Long idCliente;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento ;
    private String user;
    private String password;
}
