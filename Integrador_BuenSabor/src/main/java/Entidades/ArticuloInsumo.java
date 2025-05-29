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

public class ArticuloInsumo extends Articulo{

    private double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private boolean esParaElaborar;

    @Override
    public String toString() {
        return "ArticuloInsumo{" +
                "precioCompra=" + precioCompra +
                ", stockActual=" + stockActual +
                ", stockMaximo=" + stockMaximo +
                ", esParaElaborar=" + esParaElaborar +
                ", denominacion='" + denominacion + '\'' +
                ", precioVenta=" + precioVenta +
                '}';
    }
}
