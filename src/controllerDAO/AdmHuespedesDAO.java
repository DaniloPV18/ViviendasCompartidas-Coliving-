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
import javax.swing.JOptionPane;
import model.Huesped;
import utilities.Conversiones;

/**
 *
 * @author N1L0XD
 */
public class AdmHuespedesDAO {

    private static final Connection cn = Conexion.getConnection();

    private static final String INSERTAR = "  INSERT INTO huesped ("
            + "     identificador, nombres, apellidos , fecha_nac, email, estado, fecha_reg, "
            + "     identificacion_tipo_id_identificacion_tipo, sexo_id_sexo, nacionalidad_id_nacionalidad "
            + ")VALUES(?,?,?,?,?,?,?,?,?,?)";

    private static final String ACTUALIZAR = " UPDATE huesped "
            + "SET "
            + "     identificador = ?, nombres = ?, apellidos = ?, fecha_nac = ?, email = ?, "
            + "     identificacion_tipo_id_identificacion_tipo = ?, sexo_id_sexo = ?, nacionalidad_id_nacionalidad = ? "
            + "WHERE identificador = ? ";
    
    private static final String ELIMINAR = " UPDATE huesped "
            + "SET "
            + "     estado = ?"
            + "WHERE identificador = ? ";

    private static final String LISTAR = " SELECT * FROM huesped WHERE estado = 'HABILITADO' ";

    public static Connection getCn() {
        return cn;
    }
    
    //Insertar registro en BD 
    public static void insertar(Huesped huesped) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(INSERTAR);
                ps.setString(1, huesped.getIdentificador());
                ps.setString(2, huesped.getNombres());
                ps.setString(3, huesped.getApellidos());
                ps.setTimestamp(4, Conversiones.getFecha(Conversiones.getFecha(huesped.getFechaNac())));
                ps.setString(5, huesped.getEmail());
                ps.setString(6, huesped.getEstado());
                ps.setTimestamp(7, Conversiones.getFecha(Conversiones.getFecha(huesped.getFechaReg())));
                ps.setInt(8, huesped.getTipoId());
                ps.setInt(9, huesped.getSexo());
                ps.setInt(10, huesped.getNacionalidad());                
                ps.execute();
                JOptionPane.showMessageDialog(null, "Datos han sido insertados.");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Actualizar registro en BD 
    public static void actualizar(String identificadorHuesped, Huesped huesped) {
        System.out.println(identificadorHuesped + " " + huesped.toString());
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(ACTUALIZAR);
                ps.setString(1, huesped.getIdentificador());
                ps.setString(2, huesped.getNombres());
                ps.setString(3, huesped.getApellidos());
                ps.setTimestamp(4, Conversiones.getFecha(Conversiones.getFecha(huesped.getFechaNac())));
                ps.setString(5, huesped.getEmail());
                ps.setInt(6, huesped.getTipoId());
                ps.setInt(7, huesped.getSexo());
                ps.setInt(8, huesped.getNacionalidad());
                ps.setString(9, identificadorHuesped);
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Eliminado logico en BD 
    public static void eliminar(String cedula){
        String newEstado = "ELIMINADO";
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(ELIMINAR);
                ps.setString(1, newEstado);
                ps.setString(2, cedula);
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Consulta de los registros almacenados en la tabla de la BD
    public static ArrayList<Huesped> consultar() {
        ArrayList<Huesped> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTAR);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Huesped p = new Huesped(
                            rs.getString(2),//identificador
                            rs.getString(3),//nombres
                            rs.getString(4),//apellidos
                            rs.getDate(5),//fecha_nac
                            rs.getString(6),//email
                            rs.getString(7),//estado
                            rs.getInt(9),//tipoidentificacion
                            rs.getInt(10),//sexo
                            rs.getInt(11)//nacionalidad
                    );
                    p.setId(rs.getInt(1));
                    p.setFechaReg(rs.getTimestamp(8));
                    lista.add(p);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }
}
