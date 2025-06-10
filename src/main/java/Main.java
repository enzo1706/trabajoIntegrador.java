import Entidades.*;
import Enums.Estado;
import Enums.FormaPago;
import Enums.TipoEnvio;
import Enums.TipoPromocion;
import config.Conexion;
import dao.ClienteDAO;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {
            try (Connection conn = Conexion.conectar()) {
                System.out.println(" Conexión exitosa a la base de datos.");
            } catch (Exception e) {
                System.out.println(" Error al conectar a la base de datos:");
                e.printStackTrace();
                return;
            }


            // creamos una Empresa
            Empresa empresa = Empresa.builder()
                    .nombre("Dr gula")
                    .razonSocial("Dr gula SRL")
                    .cuil(123456789)
                    .build();

            System.out.println(empresa);
            System.out.println("-----");

            // creamos 2 sucursales
            Sucursal sucursal1 = Sucursal.builder()
                    .nombre("Sucursal Centro ")
                    .horarioApertura(LocalTime.of(19, 0))
                    .horarioCierre(LocalTime.of(0, 0))
                    .build();

            System.out.println(sucursal1);
            System.out.println("-----");

            Sucursal sucursal2 = Sucursal.builder()
                    .nombre("Sucursal Guaymallen ")
                    .horarioApertura(LocalTime.of(19, 0))
                    .horarioCierre(LocalTime.of(0, 0))
                    .build();

            System.out.println(sucursal2);
            System.out.println("-----");

            empresa.agregarSucursal(sucursal1);
            empresa.agregarSucursal(sucursal2);


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

            // creamos los 2 domicilios
            Domicilio domicilio1 = Domicilio.builder()
                    .calle("Av. San Martin 742 Cuidad ")
                    .numero(742)
                    .cp(5500)
                    .localidad(localidad2)
                    .build();

            System.out.println(domicilio1);
            System.out.println("-----");

            Domicilio domicilio2 = Domicilio.builder()
                    .calle("Bandera de los Andes 386, Guaymallen ")
                    .numero(386)
                    .cp(5521)
                    .localidad(localidad1)
                    .build();



            // creamos clientes con sus respectivos usuarios
            Cliente cli_1 = Cliente.builder()
                    .nombre("Tomas ")
                    .apellido("Ferreyra ")
                    .telefono("2615489754")
                    .email("tomas@gmail.com ")
                    .fechaNacimiento(LocalDate.of(2006, 3, 5))
                    .domicilio(domicilio1)
                    .build();

            System.out.println(cli_1);
            System.out.println("-----");

            Cliente cli_2 = Cliente.builder()
                    .nombre("Gustavo ")
                    .apellido("Rodriguez ")
                    .telefono("2616536002")
                    .email("gustavo@gmail.com ")
                    .fechaNacimiento(LocalDate.of(2006, 4, 17))
                    .domicilio(domicilio2)
                    .build();

            System.out.println(cli_2);
            System.out.println("-----");

            ClienteDAO clienteDAO = new ClienteDAO();

            // Inserta los dos clientes
            clienteDAO.insertarCliente(cli_1);
            clienteDAO.insertarCliente(cli_2);
            System.out.println("-----");

            // obtener todos los clientes de la base
            System.out.println(" Clientes en la base:");
            List<Cliente> clientes = clienteDAO.obtenerTodos();
            clientes.forEach(System.out::println);
            System.out.println("-----");

            // buscar cliente por email
            System.out.println(" Buscando cliente por email:");
            Cliente encontrado = clienteDAO.buscarPorEmail("gustavo@gmail.com");
            System.out.println(encontrado != null ? encontrado : "No se encontró el cliente.");
            System.out.println("-----");

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
                    .estado(Estado.ENTRGADO)
                    .tipoEnvio(TipoEnvio.DELIVERY)
                    .formaPago(FormaPago.MERCADOPAGO)
                    .fechaPedido(LocalDate.of(2025, 5, 20))
                    .build();

            System.out.println("-----PEDIDO 1-----");
            System.out.println(ped1);
            System.out.println("-----");


            sucursal1.agregarPedidos(ped1);

            DetallePedido detalle1 = DetallePedido.builder()
                    .id(300L)
                    .cantidad(2)
                    .subtotal(3000)
                    .pedido(ped1)
                    .build();

            ped1.agregarDetalle(detalle1);

            Pedido ped2 = Pedido.builder()
                    .id(101L)
                    .horaEstimadaFinalizacion(LocalTime.of(22, 0))
                    .total(20000)
                    .totalCosto(13000)
                    .estado(Estado.PENDIENTE)
                    .tipoEnvio(TipoEnvio.TAKEAWAY)
                    .formaPago(FormaPago.MERCADOPAGO)
                    .fechaPedido(LocalDate.of(2025, 5, 18))
                    .build();

            System.out.println("-----PEDIDO 2-----");
            System.out.println(ped2);
            System.out.println("-----");


            sucursal2.agregarPedidos(ped2);

            DetallePedido detalle2 = DetallePedido.builder()
                    .id(301L)
                    .cantidad(1)
                    .subtotal(7000)
                    .pedido(ped2)
                    .build();

            ped2.agregarDetalle(detalle2);

            cli_1.agregarPedidos(ped1);

            // creamos las facturas de los pedidos
            Factura fac1 = Factura.builder()
                    .id(400L)
                    .fechaFacturacion(LocalDate.now())
                    .formaPago(FormaPago.MERCADOPAGO)
                    .mpMerchantOrderId(12345)
                    .mpPaymentId(898546)
                    .mpPreferenceId("pref123 ")
                    .mpPaymentType("Mercado pago ")
                    .totalVenta(13000)
                    .pedido(ped1)
                    .build();

            System.out.println(fac1);
            System.out.println("-----");

            Factura fac2 = Factura.builder()
                    .id(401L)
                    .fechaFacturacion(LocalDate.now())
                    .formaPago(FormaPago.MERCADOPAGO)
                    .mpMerchantOrderId(18745)
                    .mpPaymentId(898123)
                    .mpPreferenceId("pref456 ")
                    .mpPaymentType("Mercado pago ")
                    .totalVenta(20000)
                    .pedido(ped2)
                    .build();

            System.out.println(fac2);
            System.out.println("-----");





            // creamos articulos
            ArticuloInsumo carne = ArticuloInsumo.builder()
                    .id(10L)
                    .denominacion("Carne de la hamburguesa ")
                    .precioVenta(0)
                    .precioCompra(3000)
                    .stockActual(30)
                    .stockMaximo(60)
                    .esParaElaborar(true)
                    .build();

            ArticuloInsumo pan = ArticuloInsumo.builder()
                    .id(11L)
                    .denominacion("Pan de la hamburguesa ")
                    .precioVenta(0)
                    .precioCompra(300)
                    .stockActual(10)
                    .stockMaximo(40)
                    .esParaElaborar(true)
                    .build();


            ArticuloManufacturado hambManu = ArticuloManufacturado.builder()
                    .id(12L)
                    .denominacion("Hambuerguesa clasica ")
                    .precioVenta(12000)
                    .descripcion(" carne, pan, cheddar, tomate, lechuga y cebolla ")
                    .tiempoEstimadosMinutos(10)
                    .preparacion("Armar paso por paso y luego envolver en papel aluminio ")
                    .build();

            ArticuloManufacturadoDetalle detalleHamb = ArticuloManufacturadoDetalle.builder()
                    .id(13L)
                    .cantidad(1)
                    .build();

            // cargamos una promocion
            Promocion promo = Promocion.builder()
                    .id(500L)
                    .denominacion("Combo 2x1 por el dia de la hamburguesa ")
                    .FechaDesde(LocalDate.of(2025, 5, 20))
                    .FechaHasta(LocalDate.of(2025, 5, 27))
                    .HoraDesde(LocalTime.of(19, 0))
                    .HoraHasta(LocalTime.of(23, 0))
                    .descripcionDescuento("2x1 en hamburguesas dobles a eleccion pagando con efectivo")
                    .precioPromocional(10000)
                    .tipoPromocion(TipoPromocion.PROMOCION1)
                    .build();

            System.out.println(promo);

            sucursal1.agregarPromociones(promo);
            sucursal2.agregarPromociones(promo);

            hambManu.agregarDetalle(detalleHamb);

            // creamos imagen, categoria e unidad de medida
            Imagen img = Imagen.builder()
                    .id(14L)
                    .denominacion("hamburguesa_clasica.jpg ")
                    .build();

            Categoria cat = Categoria.builder()
                    .id(15L)
                    .denominacion("Combos ")
                    .subctegoria("Hamburguesas")
                    .build();

            sucursal1.agregarCategorias(cat);

            UnidadMedida unidadMedida = UnidadMedida.builder()
                    .id(16L)
                    .denominacion("Unidad ")
                    .build();

        } catch (Exception e) {
            e.printStackTrace(); // Mostrará en consola si algo falla en tiempo de ejecución
        }

    }
}
