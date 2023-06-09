/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peliculas.Modelo;

import Peliculas.Controlador.clsPeliculasSalas;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */

//Hecho por Carlos González, 9959-20-6164

public class daoPeliculasSalas {

private static final String SQL_SELECT = "SELECT idSalas, idCines, fkCine, Descripción, formatoPeli, puntos, precioSala FROM tbl_Salas";
private static final String SQL_INSERT = "INSERT INTO tbl_Salas(idSalas, idCines, fkCine, Descripción, formatoPeli, puntos, precioSala) VALUES(?, ?, ?, ?, ?, ?, ?)";
private static final String SQL_UPDATE = "UPDATE tbl_Salas SET idCines=?, fkCine=?, Descripción=?, formatoPeli=?, puntos=?, precioSala=? WHERE idSalas = ?";
private static final String SQL_DELETE = "DELETE FROM tbl_Salas WHERE idSalas=?";
private static final String SQL_SELECT_ID = "SELECT idSalas, idCines, fkCine, Descripción, formatoPeli, puntos, precioSala FROM tbl_Salas WHERE idSalas = ?";  



 public List<clsPeliculasSalas> consultaSala() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    List<clsPeliculasSalas> salas = new ArrayList<>();
    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while (rs.next()) {
            int idSalas = rs.getInt("idSalas");
            int idCines = rs.getInt("idCines");
            int fkCine = rs.getInt("fkCine");
            String descripcion = rs.getString("Descripción");
            String formatoPeli = rs.getString("formatoPeli");
            int puntos = rs.getInt("puntos");
            double precioSala = rs.getDouble("precioSala");

            clsPeliculasSalas sala = new clsPeliculasSalas();
            sala.setIdSalas(idSalas);
            sala.setIdCines(idCines);
            sala.setFkCines(fkCine);
            sala.setDescripcion(descripcion);
            sala.setFormatoPeli(formatoPeli);
            sala.setPuntos(puntos);
            sala.setPrecioSala(precioSala);

            salas.add(sala);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    return salas;
}

public int ingresarSala(clsPeliculasSalas sala) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_INSERT);
        stmt.setInt(1, sala.getIdSalas());
        stmt.setInt(2, sala.getIdCines());
        stmt.setInt(3, sala.getFkCines());
        stmt.setString(4, sala.getDescripcion());
        stmt.setString(5, sala.getFormatoPeli());
        stmt.setInt(6, sala.getPuntos());
        stmt.setDouble(7, sala.getPrecioSala());

        System.out.println("Ejecutando query: " + SQL_INSERT);
        rows = stmt.executeUpdate();
        System.out.println("Registros afectados: " + rows);
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return rows;
}

public int actualizarSala(clsPeliculasSalas sala) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query: " + SQL_UPDATE);
        stmt = conn.prepareStatement(SQL_UPDATE);
        stmt.setInt(1, sala.getIdCines());
        stmt.setInt(2, sala.getFkCines());
        stmt.setString(3, sala.getDescripcion());
        stmt.setString(4, sala.getFormatoPeli());
        stmt.setInt(5, sala.getPuntos());
        stmt.setDouble(6, sala.getPrecioSala());
        stmt.setInt(7, sala.getIdSalas());

        rows = stmt.executeUpdate();
        System.out.println("Registros actualizados: " + rows);
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return rows;
}

public int borrarSala(clsPeliculasSalas sala) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;

    try {
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query: " + SQL_DELETE);
        stmt = conn.prepareStatement(SQL_DELETE);
        stmt.setInt(1, sala.getIdSalas());
        rows = stmt.executeUpdate();
        System.out.println("Registros eliminados: " + rows);
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return rows;
}

public clsPeliculasSalas consultarSalaPorId(clsPeliculasSalas sala) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query: " + SQL_SELECT_ID + " objeto recibido: " + sala);
        stmt = conn.prepareStatement(SQL_SELECT_ID);
        stmt.setInt(1, sala.getIdSalas());
        rs = stmt.executeQuery();
        while (rs.next()) {
            int idSalas = rs.getInt("idSalas");
            int idCines = rs.getInt("idCines");
            int fkCine = rs.getInt("fkCine");
            String descripcion = rs.getString("Descripción");
            String formatoPeli = rs.getString("formatoPeli");
            int puntos = rs.getInt("puntos");
            double precioSala = rs.getDouble("precioSala");

            sala.setIdSalas(idSalas);
            sala.setIdCines(idCines);
            sala.setFkCines(fkCine);
            sala.setDescripcion(descripcion);
            sala.setFormatoPeli(formatoPeli);
            sala.setPuntos(puntos);
            sala.setPrecioSala(precioSala);

            System.out.println("Registro consultado: " + sala);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return sala;
}

}

