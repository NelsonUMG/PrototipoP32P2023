/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsBancos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// private int tipoPersona;
  //  private String descripcion;
   //git  private String Estatus;
/**
 *
 * @author visitante
 */
public class daoBancos {

    private static final String SQL_SELECT = "SELECT tipoPersona, descripcion, Estatus FROM tbl_bancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_bancos(tipoPersona, descripcion,  Estatus) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_bancos SET tipoPersona=?, Estatus=? WHERE tipoPersona = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_bancos WHERE tipoPersona=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT tipoPersona, descripcion,  Estatus FROM tbl_bancos WHERE descripcion = ?";
    private static final String SQL_SELECT_ID = "SELECT tipoPersona, descripcion, Estatus FROM tbl_bancos WHERE tipoPersona = ?";    

    public List<clsBancos> consultaBanco() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsBancos> bancos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String tipo = rs.getString("tipoPersona"); 
                String nombre = rs.getString("descripcion");
                String estatus = rs.getString("Estatus");
                clsBancos banco = new clsBancos();
                banco.setTipoPersona(tipo);
                banco.setDescripcion(nombre);
                banco.setEstatus(estatus);
                bancos.add(banco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return bancos;
    }

    public int ingresaBanco(clsBancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, banco.getTipoPersona());
            stmt.setString(2, banco.getDescripcion());
            stmt.setString(3, banco.getEstatus());

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

    public int actualizaAplicacion(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aplicacion.getNombreAplicacion());
            stmt.setString(2, aplicacion.getEstatusAplicacion());
            stmt.setInt(3, aplicacion.getIdAplicacion());

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

    public int borrarAplicacion(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getIdAplicacion());
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

    public clsAplicacion consultaAplicacionPorNombre(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aplicacion);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aplid");
                String nombre = rs.getString("aplnombre");
                String estatus = rs.getString("aplestatus");

                //aplicacion = new clsAplicacion();
                aplicacion.setIdAplicacion(id);
                aplicacion.setNombreAplicacion(nombre);
                aplicacion.setEstatusAplicacion(estatus);
                System.out.println(" registro consultado: " + aplicacion);                
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
        return aplicacion;
    }
    public clsAplicacion consultaAplicacionPorId(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aplicacion);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, aplicacion.getIdAplicacion());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("aplid");
                String nombre = rs.getString("aplnombre");
                String estatus = rs.getString("aplestatus");

                //aplicacion = new clsAplicacion();
                aplicacion.setIdAplicacion(id);
                aplicacion.setNombreAplicacion(nombre);
                aplicacion.setEstatusAplicacion(estatus);
                System.out.println(" registro consultado: " + aplicacion);                
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
        return aplicacion;
    }    
}
