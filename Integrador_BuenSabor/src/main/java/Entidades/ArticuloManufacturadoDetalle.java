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

public class ArticuloManufacturadoDetalle extends Articulo{
    private Integer cantidad;

    // relaciones
    private ArticuloInsumo articuloInsumo;
    private ArticuloManufacturado articuloManufacturado;

    @Override
    public String toString() {
        return "ArticuloManufacturadoDetalle{" +
                "denominacion='" + denominacion + '\'' +
                ", precioVenta=" + precioVenta +
                ", cantidad=" + cantidad +
                '}';
    }
}
