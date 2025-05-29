package Entidades;

import Enums.Estado;
import Enums.FormaPago;
import Enums.TipoEnvio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        // creamos una Empresa
        Empresa empresa = Empresa.builder()
                .nombre("Dr gula")
                .razonSocial("Dr gula SRL")
                .cuil(123456789)
                .build();

        System.out.println(empresa);


        // creamos 2 sucursales
        Sucursal sucursal1 = Sucursal.builder()
                .nombre("Sucursal Centro ")
                .horarioApertura(LocalTime.of(19,0))
                .horarcioCierre(LocalTime.of(24,0 ))
                .build();

        System.out.println(sucursal1);

        Sucursal sucursal2 = Sucursal.builder()
                .nombre("Sucursal Guaymallen ")
                .horarioApertura(LocalTime.of(19,0))
                .horarcioCierre(LocalTime.of(24,0 ))
                .build();

        System.out.println(sucursal2);

        empresa.agregarSucursal(sucursal1);
        empresa.agregarSucursal(sucursal2);

        // creamos los 2 domicilios
        Domicilio domicilio1 = Domicilio.builder()
                .calle("Av. San Martin 742 Cuidad ")
                .numero(742)
                .cp(5500)
                .build();


        System.out.println(domicilio1);

        Domicilio domicilio2 = Domicilio.builder()
                .calle("Bandera de los Andes 386, Guaymallen ")
                .numero(386)
                .cp(5521)
                .build();


        System.out.println(domicilio2);

        // creamos pais, provincia y localidad
        Pais pais = Pais.builder()
                .nombre("Argentina ")
                .build();


        Provincia prov = Provincia.builder()
                .nombre("Mendoza ")
                .build();

        Localidad localidad1 = Localidad.builder()
                .nombre("Guaymallen ")
                .build();


        Localidad localidad2 = Localidad.builder()
                .nombre("Ciudad de Mendoza ")
                .build();

        pais.agregarProvincia(prov);
        prov.agregarLocalidades(localidad1);
        prov.agregarLocalidades(localidad2);


        // creamos clientes con sus respectivos usuarios
        Cliente cli_1 = Cliente.builder()
                .nombre("Tomas ")
                .apellido("Ferreyra ")
                .telefono("2615489754")
                .email("tomas@gmail.com ")
                .fechaNacimiento(LocalDate.of(2006, 3, 5))
                .build();

        System.out.println(cli_1);


        Cliente cli_2 = Cliente.builder()
                .nombre("Gustavo ")
                .apellido("Rodriguez ")
                .telefono("2616536002")
                .email("gustavo@gmail.com ")
                .fechaNacimiento(LocalDate.of(2006, 4, 17))
                .build();

        System.out.println(cli_2);

        Usuario usu1 = Usuario.builder()
                .auth0Id("123abc ")
                .username("tomas4356 ")
                .build();


        Usuario usu2 = Usuario.builder()
                .auth0Id("456ghj ")
                .username("gustavo0009 ")
                .build();


        // creamos pedidos uno para cada cliente
        Pedido ped1 = Pedido.builder()
                .id(100L)
                .horaEstimadaFinalizacion(LocalTime.of(14, 0))
                .total(13000)
                .totalCosto(10000)
                .estado(Estado.entregado)
                .tipoEnvio(TipoEnvio.delivery)
                .formaPago(FormaPago.mercadoPago)
                .fechaPedido(LocalDate.of(2025, 5, 20))
                .detallePedidos(new HashSet<>())
                .build();

        System.out.println("-----PEDIDO 1-----");

        DetallePedido detalle1 = DetallePedido.builder()
                .id(300L)
                .cantidad(2)
                .subtotal(3000)
                .build();

        ped1.getDetallePedidos().add(detalle1);

        Pedido ped2 = Pedido.builder()
                .id(101L)
                .horaEstimadaFinalizacion(LocalTime.of(22, 0))
                .total(20000)
                .totalCosto(13000)
                .estado(Estado.pendiente)
                .tipoEnvio(TipoEnvio.TakeAway)
                .formaPago(FormaPago.mercadoPago)
                .fechaPedido(LocalDate.of(2025, 5, 18))
                .detallePedidos(new HashSet<>())
                .build();

        System.out.println("-----PEDIDO 2-----");

        DetallePedido detalle2 = DetallePedido.builder()
                .id(301L)
                .cantidad(1)
                .subtotal(7000)
                .build();

        ped2.getDetallePedidos().add(detalle2);

        // creamos las facturas de los pedidos
        Factura fac1 = Factura.builder()
                .id(400L)
                .fechaFacturacion(LocalDate.now())
                .formaPago(FormaPago.mercadoPago)
                .mpMerchantOrderId(12345)
                .mpPaymentId(898546)
                .mpPreferenceId("pref123 ")
                .mpPaymentType("Mercado pago ")
                .totalVenta(13000)
                .pedido(ped1)
                .build();

        Factura fac2 = Factura.builder()
                .id(401L)
                .fechaFacturacion(LocalDate.now())
                .formaPago(FormaPago.mercadoPago)
                .mpMerchantOrderId(18745)
                .mpPaymentId(898123)
                .mpPreferenceId("pref456 ")
                .mpPaymentType("Mercado pago ")
                .totalVenta(20000)
                .pedido(ped2)
                .build();

    }
}
