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
import model.Vivienda;
import utilities.Conversiones;

/**
 *
 * @author N1L0XD
 */
public class AdmViviendasDAO {

    private static final Connection cn = Conexion.getConnection();

    private static final String INSERTAR = "  INSERT INTO vivienda ("
            + "     identificador, nombre, email, direccion, num_hab, fecha_reg, "
            + "     anfitrion_id_persona, vivienda_tipo_id_vivienda_tipo, vivienda_estado_id_vivienda_estado, ciudad_id_ciudad"
            + ")VALUES(?,?,?,?,?,?,?,?,?,?)";

    private static final String ACTUALIZAR = " UPDATE vivienda "
            + "SET "
            + "     identificador = ?, nombre = ?, email = ?, direccion = ?, num_hab = ?, "
            + "     anfitrion_id_persona = ?, vivienda_tipo_id_vivienda_tipo = ?, vivienda_estado_id_vivienda_estado = ?, ciudad_id_ciudad = ? "
            + "WHERE identificador = ? ";
    
    private static final String ELIMINAR = " UPDATE vivienda "
            + "SET "
            + "     vivienda_estado_id_vivienda_estado = ? "
            + "WHERE identificador = ? ";

    private static final String LISTAR = " SELECT * FROM vivienda "
            + "WHERE vivienda_estado_id_vivienda_estado = 1 or "
            + "vivienda_estado_id_vivienda_estado = 3 ";

    public static Connection getCn() {
        return cn;
    }
    
    //Insertar registro en BD 
    public static void insertar(Vivienda vivienda) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(INSERTAR);
                ps.setString(1, vivienda.getIdentificador());
                ps.setString(2, vivienda.getNombre());
                ps.setString(3, vivienda.getEmail());
                ps.setString(4, vivienda.getDireccion());
                ps.setInt   (5, vivienda.getNumHab());
                ps.setTimestamp(6, Conversiones.getFecha(Conversiones.getFecha(vivienda.getFechaReg())));                
                ps.setInt(7, vivienda.getAnfitrion());
                ps.setInt(8, vivienda.getTipoVivienda());
                ps.setInt(9, vivienda.getEstadoVivienda());                
                ps.setInt(10, vivienda.getCiudad());                
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Actualizar registro en BD 
    public static void actualizar(String identificador, Vivienda vivienda) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(ACTUALIZAR);
                ps.setString(1, vivienda.getIdentificador());
                ps.setString(2, vivienda.getNombre());
                ps.setString(3, vivienda.getEmail());
                ps.setString(4, vivienda.getDireccion());
                ps.setInt   (5, vivienda.getNumHab());            
                ps.setInt(6, vivienda.getAnfitrion());
                ps.setInt(7, vivienda.getTipoVivienda());
                ps.setInt(8, vivienda.getEstadoVivienda());                
                ps.setInt(9, vivienda.getCiudad());
                ps.setString(10, identificador);
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
    public static ArrayList<Vivienda> consultar() {
        ArrayList<Vivienda> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTAR);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Vivienda p = new Vivienda(
                            rs.getString(2),//identificador
                            rs.getString(3),//nombre
                            rs.getString(4),//email
                            rs.getString(5),//direccion
                            rs.getInt(6),//numHab
                            rs.getInt(8),//anfitrion
                            rs.getInt(9),//tipoVivienda
                            rs.getInt(10),//estadoVivienda
                            rs.getInt(11)//ciudad
                    );
                    p.setId(rs.getInt(1));
                    p.setFechaReg(rs.getTimestamp(7));                    
                    lista.add(p);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }
}
