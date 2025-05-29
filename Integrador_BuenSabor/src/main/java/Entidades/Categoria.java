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

public class Categoria extends Base{
    private String denominacion;

    // relaciones
    private Set<Sucursal> sucursales = new HashSet<>();

    public void agregarCategoria(Sucursal sucursal){
        sucursales.add(sucursal);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "denominacion='" + denominacion + '\'' +
                '}';
    }
}
