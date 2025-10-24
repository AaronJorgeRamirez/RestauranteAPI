package com.example.ApiRestaurant.Domain.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    @Column(name="nombre_cliente")
    private String nombre;
    @Column(name="apellido_cliente")
    private String apellido;
    @Column(name="edad")
    private String edad ;
    @Column(name="usuario")
    private String user;
    @Column(name="pass")
    private String password;
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
}
