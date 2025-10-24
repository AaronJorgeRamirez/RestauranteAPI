package com.example.ApiRestaurant.Application.Service;

import com.example.ApiRestaurant.Web.DTO.LoginRequest;
import com.example.ApiRestaurant.Web.DTO.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest request);

}
