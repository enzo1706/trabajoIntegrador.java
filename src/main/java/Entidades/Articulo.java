package Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public abstract class Articulo extends Base{
    protected String denominacion;
    protected double precioVenta;

    // relaciones
    private Categoria categoria;

}
