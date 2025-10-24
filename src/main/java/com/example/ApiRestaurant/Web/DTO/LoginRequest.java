package com.example.ApiRestaurant.Web.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginRequest {
    private String user;
    private String password;
}
