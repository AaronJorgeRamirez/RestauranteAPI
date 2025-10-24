package com.example.ApiRestaurant.Web.DTO;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginResponse {
    private String mensaje;
    private LocalDate fecha_ingreso;
}
