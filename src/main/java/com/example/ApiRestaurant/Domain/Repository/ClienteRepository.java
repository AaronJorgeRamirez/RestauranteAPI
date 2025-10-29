package com.example.ApiRestaurant.Domain.Repository;

import com.example.ApiRestaurant.Domain.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByUser(String user);
    boolean existsByUser(String user);
    boolean existsByPassword(String password);

}
