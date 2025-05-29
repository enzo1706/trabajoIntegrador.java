package Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private Set<Pedido> pedidos = new HashSet<>();
    private Localidad localidad;

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
