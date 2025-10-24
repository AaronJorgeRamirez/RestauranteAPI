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
            // Devuelve error 401 o 404 según el caso
            return ResponseEntity.status(401).body(
                    new LoginResponse(e.getMessage(), null)
            );
        }
    }
}