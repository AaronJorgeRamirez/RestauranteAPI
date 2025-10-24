package com.example.ApiRestaurant.Domain.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "tipo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Tipo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_tipo")
    private Long idTipo;
    @Column(name="tipo_plato")
    private String tipoPlato;
    @OneToMany(mappedBy = "tipo",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Carta> cartaList;
}
