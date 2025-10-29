package com.example.ApiRestaurant.Web.DTO;

import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PedidoRequest {
    private Long idCliente;
    private String numeroCuenta;
}
