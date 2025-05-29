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

public class DetallePedido extends Base{
    private Integer cantidad;
    private double subtotal;

    // relaciones
    private Pedido pedido;
    private Articulo articulo;

    @Override
    public String toString() {
        return "DetallePedido{" +
                "cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", pedido=" + getClass().getName() +
                ", articulo=" + articulo +
                '}';
    }
}
