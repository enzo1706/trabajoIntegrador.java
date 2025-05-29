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

public class Pais extends Base {

    private String nombre;

    // relaciones

    private Set<Provincia> provincias = new HashSet<>();

    public void agregarProvincia(Provincia provincia){
        provincias.add(provincia);
    }
}
