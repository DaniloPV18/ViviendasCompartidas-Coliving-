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
import javax.swing.JOptionPane;
import model.Persona;
import utilities.Conversiones;

/**
 *
 * @author N1L0XD
 */
public class AdmPersonasDataBase {

    private static final Connection cn = Conexion.getConnection();

    private static final String INSERTAR = "  INSERT INTO PERSONA ("
            + "     identificador, nombres, apellidos , fecha_nac, email, estado, fecha_reg, "
            + "     tipoidentificacion_id_tipoid, sexo_id_sexo, nacionalidad_id_nacionalidad "
            + ")VALUES(?,?,?,?,?,?,?,?,?,?)";

    private static final String ACTUALIZAR = " UPDATE PERSONA "
            + "SET "
            + "     identificador = ?, nombres = ?, apellidos = ?, fecha_nac = ?, email = ?, "
            + "     tipoidentificacion_id_tipoid = ?, sexo_id_sexo = ?, nacionalidad_id_nacionalidad = ? "
            + "WHERE identificador = ? ";
    
    private static final String ELIMINAR = " UPDATE PERSONA "
            + "SET "
            + "     estado = ?"
            + "WHERE identificador = ? ";

    private static final String LISTAR = " SELECT * FROM PERSONA WHERE estado = 'HABILITADO' ";

    public static Connection getCn() {
        return cn;
    }
    
    //Insertar registro en BD 
    public static void insertar(Persona persona) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(INSERTAR);
                ps.setString(1, persona.getIdentificador());
                ps.setString(2, persona.getNombres());
                ps.setString(3, persona.getApellidos());
                ps.setTimestamp(4, Conversiones.getFecha(Conversiones.getFecha(persona.getFechaNac())));
                ps.setString(5, persona.getEmail());
                ps.setString(6, persona.getEstado());
                ps.setTimestamp(7, Conversiones.getFecha(Conversiones.getFecha(persona.getFechaReg())));
                ps.setInt(8, persona.getTipoId());
                ps.setInt(9, persona.getSexo());
                ps.setInt(10, persona.getNacionalidad());                
                ps.execute();
                JOptionPane.showMessageDialog(null, "Datos han sido insertados.");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    //Actualizar registro en BD 
    public static void actualizar(String identificadorPersona, Persona persona) {
        System.out.println(identificadorPersona + " " + persona.toString());
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(ACTUALIZAR);
                ps.setString(1, persona.getIdentificador());
                ps.setString(2, persona.getNombres());
                ps.setString(3, persona.getApellidos());
                ps.setTimestamp(4, Conversiones.getFecha(Conversiones.getFecha(persona.getFechaNac())));
                ps.setString(5, persona.getEmail());
                ps.setInt(6, persona.getTipoId());
                ps.setInt(7, persona.getSexo());
                ps.setInt(8, persona.getNacionalidad());
                ps.setString(9, identificadorPersona);
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
    public static ArrayList<Persona> consultar() {
        ArrayList<Persona> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTAR);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Persona p = new Persona(
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
