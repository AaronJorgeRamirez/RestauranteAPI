package com.example.ApiRestaurant.Domain.Repository;

import com.example.ApiRestaurant.Domain.Models.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartaRepository extends JpaRepository<Carta,Long> {
    List<Carta> findAllByTipo_IdTipo(Long idTipo);
    List<Carta> findAllByCategoria_idCat(Long idCat);
    Optional<Carta> findByNombreCarta(String nombreCarta);
}
