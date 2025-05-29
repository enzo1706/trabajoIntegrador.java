package Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Sucursal extends Base {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarcioCierre;

    // relaciones
    private Empresa empresa;
    private Domicilio domicilio;
    private Set<Pedido> pedidos = new HashSet<>();

    public void agregarPedidos(Pedido pedido){
        pedidos.add(pedido);
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "nombre='" + nombre + '\'' +
                ", horarioApertura=" + horarioApertura +
                ", horarcioCierre=" + horarcioCierre +
                ", empresa=" + empresa +
                ", domicilio=" + domicilio +
                ", pedidos=" + pedidos +
                '}';
    }
}
