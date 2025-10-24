package com.example.ApiRestaurant.Application.Service.Impl;

import com.example.ApiRestaurant.Application.Mapper.ClienteMapper;
import com.example.ApiRestaurant.Application.Mapper.LoginMapper;
import com.example.ApiRestaurant.Application.Service.LoginService;
import com.example.ApiRestaurant.Domain.Repository.ClienteRepository;
import com.example.ApiRestaurant.Web.DTO.LoginRequest;
import com.example.ApiRestaurant.Web.DTO.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final ClienteRepository clienteRepository;
    private final LoginMapper loginMapper;

    @Override
    public LoginResponse login(LoginRequest request) {
        var cliente = clienteRepository.findByUser(request.getUser())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!cliente.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }


        // Usamos el mapper para convertir de Entity a Response
        return loginMapper.toDto(cliente);
    }
}
