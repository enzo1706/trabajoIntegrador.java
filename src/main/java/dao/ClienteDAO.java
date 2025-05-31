package dao;

import Entidades.Cliente;
import config.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // insertamos los clientes
    public void insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, apellido, telefono, email, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getEmail());
            stmt.setDate(5, Date.valueOf(cliente.getFechaNacimiento()));

            stmt.executeUpdate();
            System.out.println(" Cliente insertado: " + cliente.getNombre());

        } catch (SQLException e) {
            System.out.println(" Error al insertar cliente:");
            e.printStackTrace();
        }
    }

    // mostramos todos los clientes
    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = Cliente.builder()
                        .id(rs.getLong("id"))
                        .nombre(rs.getString("nombre"))
                        .apellido(rs.getString("apellido"))
                        .telefono(rs.getString("telefono"))
                        .email(rs.getString("email"))
                        .fechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate())
                        .build();

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println(" Error al obtener clientes:");
            e.printStackTrace();
        }

        return clientes;
    }

    // buscamos un cliente por email
    public Cliente buscarPorEmail(String email) {
        String sql = "SELECT * FROM cliente WHERE email = ?";
        Cliente cliente = null;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = Cliente.builder()
                        .id(rs.getLong("id"))
                        .nombre(rs.getString("nombre"))
                        .apellido(rs.getString("apellido"))
                        .telefono(rs.getString("telefono"))
                        .email(rs.getString("email"))
                        .fechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate())
                        .build();
            }

        } catch (SQLException e) {
            System.out.println(" Error al buscar cliente:");
            e.printStackTrace();
        }

        return cliente;
    }
}
