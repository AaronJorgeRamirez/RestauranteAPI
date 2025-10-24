package com.example.ApiRestaurant.Domain.Repository;

import com.example.ApiRestaurant.Domain.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
