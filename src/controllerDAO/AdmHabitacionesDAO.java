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
import model.Habitacion;
import utilities.Conversiones;

/**
 *
 * @author N1L0XD
 */
public class AdmHabitacionesDAO {

    private static final Connection cn = Conexion.getConnection();

    private static final String INSERTAR = "  INSERT INTO habitacion ("
            + "     identificador, num_max_per, banio , precio, fecha_reg, "
            + "     habitacion_tipo_id_habitacion_tipo, vivienda_id_vivienda, habitacion_estado_id_habitacion_estado"
            + ")VALUES(?,?,?,?,?,?,?,?)";

    private static final String ACTUALIZAR = " UPDATE habitacion "
            + "SET "
            + "     identificador = ?, num_max_per = ?, banio = ?, precio = ?, "
            + "     habitacion_tipo_id_habitacion_tipo = ?, vivienda_id_vivienda = ?, habitacion_estado_id_habitacion_estado = ? "
            + "WHERE id_habitacion = ? ";
    
    private static final String ELIMINAR = " UPDATE habitacion "
            + "SET "
            + "     habitacion_estado_id_habitacion_estado = ? "
            + "WHERE identificador = ? ";

    private static final String LISTAR = " SELECT * FROM habitacion "
            + "WHERE habitacion_estado_id_habitacion_estado = 1 or "
            + "habitacion_estado_id_habitacion_estado = 3 ";

    public static Connection getCn() {
        return cn;
    }
    
    //Insertar registro en BD 
    public static void insertar(Habitacion habitacion) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(INSERTAR);
                ps.setInt   (1, habitacion.getIdentificador());
                ps.setInt   (2, habitacion.getNumMax());
                ps.setBoolean(3, habitacion.getBanios());
                ps.setDouble(4, habitacion.getPrecio());
                ps.setTimestamp(5, Conversiones.getFecha(Conversiones.getFecha(habitacion.getFechaReg()))); 
                ps.setInt(6, habitacion.getTipoHab());
                ps.setInt(7, habitacion.getPropiedad());
                ps.setInt(8, habitacion.getEstadoHab());            
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Actualizar registro en BD 
    public static void actualizar(int id, Habitacion habitacion) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(ACTUALIZAR);
                ps.setInt   (1, habitacion.getIdentificador());
                ps.setInt   (2, habitacion.getNumMax());
                ps.setBoolean(3, habitacion.getBanios());
                ps.setDouble(4, habitacion.getPrecio());
                ps.setInt(5, habitacion.getTipoHab());
                ps.setInt(6, habitacion.getPropiedad());
                ps.setInt(7, habitacion.getEstadoHab());   
                ps.setInt(8, id);
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Eliminado logico en BD 
    public static void eliminar(String identificador){
        int newEstado = 2;
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(ELIMINAR);
                ps.setInt(1, newEstado);
                ps.setString(2, identificador);
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Consulta de los registros almacenados en la tabla de la BD
    public static ArrayList<Habitacion> consultar() {
        ArrayList<Habitacion> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTAR);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Habitacion p = new Habitacion(
                            rs.getInt(2),//identificador
                            rs.getInt(3),//num_max_per
                            rs.getBoolean(4),//banio
                            rs.getDouble(5),//precio
                            rs.getInt(7),//tipohabitacion_id_tipohab
                            rs.getInt(8),//propiedad_id_propiedad
                            rs.getInt(9)//estadohabitacion_id_estadohab
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
}
