/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peliculas.Modelo;

import Peliculas.Controlador.clsPeliculasCines;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */

//Hecho por Carlos González, 9959-20-6164

public class daoPeliculasCines {

private static final String SQL_SELECT = "SELECT idCines, Nombre, Dirección FROM tbl_Cines";
private static final String SQL_INSERT = "INSERT INTO tbl_Cines(Nombre, Dirección) VALUES(?, ?)";
private static final String SQL_UPDATE = "UPDATE tbl_Cines SET Nombre=?, Dirección=? WHERE idCines = ?";
private static final String SQL_DELETE = "DELETE FROM tbl_Cines WHERE idCines=?";
private static final String SQL_SELECT_NOMBRE = "SELECT idCines, Nombre, Dirección FROM tbl_Cines WHERE Nombre = ?";
private static final String SQL_SELECT_ID = "SELECT idCines, Nombre, Dirección FROM tbl_Cines WHERE idCines = ?";     



   public List<clsPeliculasCines> consultaCine() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsPeliculasCines> cines = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idCines");
                String nombre = rs.getString("Nombre");
                String ciness = rs.getString("Dirección");
                clsPeliculasCines cine = new clsPeliculasCines();
                cine.setIdCines(id);
                cine.setNombreCine(nombre);
                cine.setDireccionCine(ciness);
            
                cines.add(cine);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cines;
    }


     public int ingresarCine(clsPeliculasCines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cine.getIdCines());
            stmt.setString(2, cine.getNombreCine());
            stmt.setString(3, cine.getDireccionCine());
       
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaCine (clsPeliculasCines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cine.getNombreCine());
            stmt.setString(2, cine.getDireccionCine());
            stmt.setInt(3, cine.getIdCines());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarCine(clsPeliculasCines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cine.getIdCines());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsPeliculasCines consultaCinePorNombre(clsPeliculasCines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cine);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, moneda.getIdMoneda());            
            stmt.setString(1, cine.getNombreCine());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idCines");
                String nombre = rs.getString("Nombre");
                String Direccion = rs.getString("Dirección");
           
                //moneda = new clsTipoMoneda();
                cine.setIdCines(id);
                cine.setNombreCine(nombre);
                cine.setDireccionCine(Direccion);
  
                System.out.println(" registro consultado: " + cine);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return cine;
    }
    public clsPeliculasCines consultaCinePorId(clsPeliculasCines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cine);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, cine.getIdCines());            
            //stmt.setString(1, moneda.getTipMondNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idCines");
                String nombre = rs.getString("Nombre");
                String Direccion = rs.getString("Direccion");
                //moneda = new clsTipoMoneda();
                cine.setIdCines(id);
                cine.setNombreCine(nombre);
                cine.setDireccionCine(Direccion);
                System.out.println(" registro consultado: " + cine);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return cine;
    }    
}
