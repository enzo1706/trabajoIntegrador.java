package Entidades;

import Enums.TipoPromocion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Promocion extends Base {
    private String denominacion;
    private LocalDate FechaDesde;
    private LocalDate FechaHasta;
    private LocalTime HoraDesde;
    private LocalTime HoraHasta;
    private String descripcionDescuento;
    private double precioPromocional;
    private TipoPromocion tipoPromocion;

    // relaciones
    private Set<Articulo> articulos = new HashSet<>();
    private Set<Sucursal> sucursales = new HashSet<>();

    public void agregarArticulos(Articulo articulo){
        articulos.add(articulo);
    }

    public void agregarSucursal(Sucursal sucursal){
        sucursales.add(sucursal);
    }

    @Override
    public String toString() {
        return "Promocion{" +
                "denominacion='" + denominacion + '\'' +
                ", FechaDesde=" + FechaDesde +
                ", FechaHasta=" + FechaHasta +
                ", HoraDesde=" + HoraDesde +
                ", HoraHasta=" + HoraHasta +
                ", descripcionDescuento='" + descripcionDescuento + '\'' +
                ", precioPromocional=" + precioPromocional +
                ", tipoPromocion=" + tipoPromocion +
                '}';
    }
}
