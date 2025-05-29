package Entidades;

import Enums.Estado;
import Enums.FormaPago;
import Enums.TipoEnvio;
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

public class Pedido extends Base {
    private LocalTime horaEstimadaFinalizacion;
    private double total;
    private double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    // relaciones
    private Set<DetallePedido> detallePedidos = new HashSet<>();
    private Factura factura;
    private Domicilio domicilio;

    @Override
    public String toString() {
        return "Pedido{" +
                "horaEstimadaFinalizacion=" + horaEstimadaFinalizacion +
                ", total=" + total +
                ", totalCosto=" + totalCosto +
                ", estado=" + estado +
                ", tipoEnvio=" + tipoEnvio +
                ", formaPago=" + formaPago +
                ", fechaPedido=" + fechaPedido +
                ", detallePedidos=" + detallePedidos +
                ", factura=" + factura +
                ", domicilio=" + domicilio +
                '}';
    }
}
