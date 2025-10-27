package com.example.ApiRestaurant.Domain.Models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "carta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Carta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_carta")
    private Long idCarta;
    @Column(name = "nombre_carta")
    private String nombreCarta;
    @Column(name = "precio")
    private BigDecimal precio;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;
}
