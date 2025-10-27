package com.example.ApiRestaurant.Domain.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Categoria {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Long idCat;
    @Column(name="nombre_categoria")
    private String nomCat;

}
