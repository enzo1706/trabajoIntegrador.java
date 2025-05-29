package Entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Domicilio extends Base {
    private String calle;
    private Integer numero;
    private Integer cp;

    // relaciones

    private Sucursal sucursal;
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
    private Localidad localidad;

    public void agregarPedidos(Pedido pedido){
        pedidos.add(pedido);
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "calle='" + calle + '\'' +
                ", numero=" + numero +
                ", cp=" + cp +
                ", sucursal=" + getClass().getName() +
                '}';
    }
}
