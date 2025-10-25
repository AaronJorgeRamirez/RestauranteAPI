package com.example.ApiRestaurant.Web.Controller;

import com.example.ApiRestaurant.Application.Service.LoginService;
import com.example.ApiRestaurant.Web.DTO.LoginRequest;
import com.example.ApiRestaurant.Web.DTO.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = loginService.login(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            LoginResponse errorResponse = new LoginResponse();
            errorResponse.setMensaje(e.getMessage());
            return ResponseEntity.status(401).body(errorResponse);
        }
    }
}