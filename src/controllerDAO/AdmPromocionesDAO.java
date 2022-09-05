/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerDAO;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Promocion;
import model.PromocionHabitacion;
import utilities.Conversiones;

/**
 *
 * @author N1L0XD
 */
public class AdmPromocionesDAO {

    private static final Connection cn = Conexion.getConnection();

    private static final String INSERTAR = "  INSERT INTO promocion ("
            + "     fecha_inicial, fecha_final, descuento_habitacion, estado, fecha_reg"
            + ")VALUES(?,?,?,?,?)";

    private static final String ACTUALIZAR = " UPDATE promocion "
            + "SET "
            + "     fecha_inicial = ? , fecha_final = ? , descuento_habitacion = ? "
            + " WHERE id_promocion = ? ";
    
    private static final String ELIMINAR = " UPDATE promocion "
            + "SET "
            + "     estado = ? "
            + "WHERE id_promocion = ? ";

    private static final String LISTAR = " SELECT * FROM promocion "
            + "WHERE estado = 'A' " ;
    
    private static String CONSULTARVISTA = "SELECT * FROM v_promo_hab";

    public static Connection getCn() {
        return cn;
    }
    
    //Insertar registro en BD 
    public static void insertar(Promocion promocion) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(INSERTAR);
                ps.setTimestamp (1, Conversiones.getFecha(Conversiones.getFecha(promocion.getFechaInicio())));
                ps.setTimestamp (2, Conversiones.getFecha(Conversiones.getFecha(promocion.getFechaFinal())));
                ps.setInt       (3, promocion.getDescuento());
                ps.setString    (4, promocion.getEstado());
                ps.setTimestamp (5, Conversiones.getFecha(Conversiones.getFecha(promocion.getFechaReg())));            
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Actualizar registro en BD 
    public static void actualizar(int identificador, Promocion promocion) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(ACTUALIZAR);
                ps.setTimestamp (1, Conversiones.getFecha(Conversiones.getFecha(promocion.getFechaInicio())));
                ps.setTimestamp (2, Conversiones.getFecha(Conversiones.getFecha(promocion.getFechaFinal())));
                ps.setInt(3, promocion.getDescuento());
                ps.setInt(4, identificador);
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Eliminado logico en BD 
    public static void eliminar(int identificador){
        String newEstado = "I";
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(ELIMINAR);
                ps.setString(1, newEstado);
                ps.setInt   (2, identificador);
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Consulta de los registros almacenados en la tabla de la BD
    public static ArrayList<Promocion> consultar() {
        ArrayList<Promocion> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTAR);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Promocion p = new Promocion(
                            rs.getDate(2),
                            rs.getDate(3),
                            rs.getInt(4),
                            rs.getString(5)
                    );
                    p.setId(rs.getInt(1));
                    p.setFechaReg(rs.getTimestamp(6));                    
                    lista.add(p);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }
    
    public static ArrayList<PromocionHabitacion> consultarPromoHabitacion() {
        ArrayList<PromocionHabitacion> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(CONSULTARVISTA);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    PromocionHabitacion p = new PromocionHabitacion(
                            rs.getString(1),
                            rs.getInt(2),
                            rs.getDouble(3),
                            rs.getDouble(4)
                    );                  
                    lista.add(p);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }
}
