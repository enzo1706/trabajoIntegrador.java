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

public class Localidad extends Base{
    private String nombre;

    // relaciones
    @Builder.Default
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
