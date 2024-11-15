package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private Connection conexion;

    public EquipoDAO() {
        try {
            // Conectar a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/torneo", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean agregarEquipo(Equipo equipo) {
        String sql = "INSERT INTO equipos (equipo, ciudad, entrenador) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, equipo.getEquipo());
            stmt.setString(2, equipo.getCiudad());
            stmt.setString(3, equipo.getEntrenador());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarEquipoPorNombre(String nombre) {
        String sql = "DELETE FROM equipos WHERE equipo = ?"; 
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Equipo> obtenerEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT * FROM equipos";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("equipo"); 
                String ciudad = rs.getString("ciudad");
                String entrenador = rs.getString("entrenador");
                equipos.add(new Equipo(id, nombre, ciudad, entrenador));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipos;
    }
}


