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

public class ArticuloManufacturado extends Articulo{
    private String denominacion;
    private String descripcion;
    private Integer tiempoEstimadosMinutos;
    private String preparacion;

    @Override
    public String toString() {
        return "ArticuloManufacturado{" +
                "denominacion='" + denominacion + '\'' +
                ", tiempoEstimadosMinutos=" + tiempoEstimadosMinutos +
                ", preparacion='" + preparacion + '\'' +
                ", denominacion='" + denominacion + '\'' +
                ", precioVenta=" + precioVenta +
                '}';
    }
}
