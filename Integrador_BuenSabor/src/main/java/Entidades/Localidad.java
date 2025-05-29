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

public class Localidad extends Base{
    private String nombre;

    // relaciones
    private Set<Domicilio> domicilios = new HashSet<>();
    private Provincia provincia;

    public void agregarDomicilio(Domicilio domicilio){
        domicilios.add(domicilio);
    }

    @Override
    public String toString() {
        return "Localidad{" +
                "nombre='" + nombre + '\'' +
                ", provincia=" + getClass().getName() +
                '}';
    }
}
