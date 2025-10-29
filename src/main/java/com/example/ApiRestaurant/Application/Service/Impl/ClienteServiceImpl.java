package com.example.ApiRestaurant.Application.Service.Impl;

import com.example.ApiRestaurant.Application.Mapper.ClienteMapper;
import com.example.ApiRestaurant.Application.Service.ClienteService;
import com.example.ApiRestaurant.Domain.Models.Cliente;
import com.example.ApiRestaurant.Domain.Repository.ClienteRepository;
import com.example.ApiRestaurant.Web.DTO.ClienteRequest;
import com.example.ApiRestaurant.Web.DTO.ClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteResponse crearCliente(ClienteRequest dto) {
        if(clienteRepository.existsByPassword(dto.getPassword()) && !clienteRepository.existsByUser(dto.getUser())){
            throw new RuntimeException("Esta contraseña ya existe");
        }
        if(clienteRepository.existsByUser(dto.getUser()) && !clienteRepository.existsByPassword(dto.getPassword()) ){
            throw new RuntimeException("Este usuario ya existe");
        }
        if(clienteRepository.existsByUser(dto.getUser()) && clienteRepository.existsByPassword(dto.getPassword()) ){
            throw new RuntimeException("Ambas credenciales ya existen");
        }
        Cliente cliente = clienteMapper.toEntity(dto);
        Cliente guardado = clienteRepository.save(cliente);
        return clienteMapper.toDto(guardado);
    }

    @Override
    public ClienteResponse obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + id));
    }

}
