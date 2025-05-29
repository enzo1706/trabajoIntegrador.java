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

public class Empresa extends Base{
    private String nombre;
    private String razonSocial;
    private Integer cuil;

    // relaciones
    private Set<Sucursal> sucursales = new HashSet<>();

    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", cuil=" + cuil +
                ", sucursales=" + sucursales +
                '}';
    }
}
