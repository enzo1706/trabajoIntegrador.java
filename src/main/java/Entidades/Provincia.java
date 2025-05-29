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

public class Provincia extends Base {
    private String nombre;

    // relaciones
    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();

    public void agregarLocalidades(Localidad localidad){
        localidades.add(localidad);
    }
}
