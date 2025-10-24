package com.example.ApiRestaurant.Domain.Repository;

import com.example.ApiRestaurant.Domain.Models.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo,Long> {
}
