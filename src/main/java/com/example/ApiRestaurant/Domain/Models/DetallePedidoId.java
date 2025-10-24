package com.example.ApiRestaurant.Domain.Models;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoId implements Serializable {

    private Long idPedido;
    private Long idCarta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetallePedidoId that)) return false;
        return Objects.equals(idPedido, that.idPedido) &&
                Objects.equals(idCarta, that.idCarta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idCarta);
    }
}
