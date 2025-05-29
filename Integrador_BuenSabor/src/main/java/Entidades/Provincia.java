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

public class Provincia extends Base {
    private String nombre;

    // relaciones
    private Set<Localidad> localidades = new HashSet<>();

    public void agregarLocalidades(Localidad localidad){
        localidades.add(localidad);
    }
}
