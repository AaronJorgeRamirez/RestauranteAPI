package com.example.ApiRestaurant.Domain.Models;

import com.example.ApiRestaurant.Domain.Models.Estados.EstadoPedido;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido ;
    @Column(name="importe_final")
    private BigDecimal importeFinal;
    @Column(name="fecha_pedido")
    private LocalDate fecha;
    @Column(name="numero_de_cuenta")
    private Long numeroCuenta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado",nullable = false)
    private EstadoPedido estado;
    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<DetallePedido> detallePedidoList;
}
