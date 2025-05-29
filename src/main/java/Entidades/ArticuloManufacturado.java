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

public class ArticuloManufacturado extends Articulo{
    private String denominacion;
    private String descripcion;
    private Integer tiempoEstimadosMinutos;
    private String preparacion;

     // relaciones
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> detalles = new HashSet<>();

    public void agregarDetalle(ArticuloManufacturadoDetalle detalle){
        detalles.add(detalle);
    }

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
