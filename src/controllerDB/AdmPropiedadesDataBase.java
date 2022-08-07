/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerDB;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Propiedad;
import utilities.Conversiones;

/**
 *
 * @author N1L0XD
 */
public class AdmPropiedadesDataBase {

    private static final Connection cn = Conexion.getConnection();

    private static final String INSERTAR = "  INSERT INTO PROPIEDAD ("
            + "     identificador, nombre, email, direccion, num_hab, fecha_reg, "
            + "     anfitrion_id_persona, tipopropiedad_id_tipopropiedad, estadopropiedad_id_estadopropiedad, ciudad_id_ciudad"
            + ")VALUES(?,?,?,?,?,?,?,?,?,?)";

    private static final String ACTUALIZAR = " UPDATE PROPIEDAD "
            + "SET "
            + "     identificador = ?, nombre = ?, email = ?, direccion = ?, num_hab = ?, "
            + "     anfitrion_id_persona = ?, tipopropiedad_id_tipopropiedad = ?, estadopropiedad_id_estadopropiedad = ?, ciudad_id_ciudad = ? "
            + "WHERE id_propiedad = ? ";
    
    private static final String ELIMINAR = " UPDATE PROPIEDAD "
            + "SET "
            + "     estadopropiedad_id_estadopropiedad = ? "
            + "WHERE identificador = ? ";

    private static final String LISTAR = " SELECT * FROM PROPIEDAD "
            + "WHERE estadopropiedad_id_estadopropiedad = 1 or "
            + "estadopropiedad_id_estadopropiedad = 3 ";

    public static Connection getCn() {
        return cn;
    }
    
    //Insertar registro en BD 
    public static void insertar(Propiedad propiedad) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(INSERTAR);
                ps.setString(1, propiedad.getIdentificador());
                ps.setString(2, propiedad.getNombre());
                ps.setString(3, propiedad.getEmail());
                ps.setString(4, propiedad.getDireccion());
                ps.setInt   (5, propiedad.getNumHab());
                ps.setTimestamp(6, Conversiones.getFecha(Conversiones.getFecha(propiedad.getFechaReg())));                
                ps.setInt(7, propiedad.getAnfitrion());
                ps.setInt(8, propiedad.getTipoPropiedad());
                ps.setInt(9, propiedad.getEstadoPropiedad());                
                ps.setInt(10, propiedad.getCiudad());                
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Actualizar registro en BD 
    public static void actualizar(int id, Propiedad propiedad) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(ACTUALIZAR);
                ps.setString(1, propiedad.getIdentificador());
                ps.setString(2, propiedad.getNombre());
                ps.setString(3, propiedad.getEmail());
                ps.setString(4, propiedad.getDireccion());
                ps.setInt   (5, propiedad.getNumHab());            
                ps.setInt(6, propiedad.getAnfitrion());
                ps.setInt(7, propiedad.getTipoPropiedad());
                ps.setInt(8, propiedad.getEstadoPropiedad());                
                ps.setInt(9, propiedad.getCiudad());
                ps.setInt(10, id);
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
    public static ArrayList<Propiedad> consultar() {
        ArrayList<Propiedad> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTAR);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Propiedad p = new Propiedad(
                            rs.getString(2),//identificador
                            rs.getString(3),//nombre
                            rs.getString(4),//email
                            rs.getString(5),//direccion
                            rs.getInt(6),//numHab
                            rs.getInt(8),//anfitrion
                            rs.getInt(9),//tipoPropiedad
                            rs.getInt(10),//estadoPropiedad
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
