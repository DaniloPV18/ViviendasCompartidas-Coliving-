/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Persona;
import utilities.Conversiones;

/**
 *
 * @author N1L0XD
 */
public class AdmPersonas {

    private static final Connection cn = Conexion.getConnection();
    
    private static final String INSERTAR    =  "  INSERT INTO PERSONA ("
                                            + "     identificador, nombres, apellidos , fecha_nac, email, estado, fecha_reg, "
                                            + "     tipoidentificacion_id_tipoid, sexo_id_sexo, nacionalidad_id_nacionalidad "
                                            + ")VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    private static final String ACTUALIZAR  =  " UPDATE PERSONA "
                                            + "SET "
                                            + "     identificador = ?, nombres = ?, apellidos = ?, fecha_nac = ?, email = ?, "
                                            + "     tipoidentificacion_id_tipoid = ?, sexo_id_sexo = ?, nacionalidad_id_nacionalidad = ?"
                                            + "WHERE id_persona = ? ";
    
    public static Connection getCn() {
        return cn;
    }

    public void insertar(Persona persona) {
        getCn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(INSERTAR);
                ps.setString(1, persona.getIdentificador());
                ps.setString(2, persona.getNombres());
                ps.setString(3, persona.getApellidos());
                ps.setDate  (4, Conversiones.getFecha(Conversiones.getFecha(persona.getFechaNac())));
                ps.setString(5, persona.getEmail());
                ps.setString(6, persona.getEstado());
                ps.setDate  (7, Conversiones.getFecha(Conversiones.getFecha(persona.getFechaReg())));
                ps.setInt   (8, persona.getTipoId().getId());
                ps.setInt   (9, persona.getSexo().getId());
                ps.setInt   (10, persona.getNacionalidad().getId());
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public void actualizar(int id, Persona persona) {
        getCn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(ACTUALIZAR);
                ps.setString(1, persona.getIdentificador());
                ps.setString(2, persona.getNombres());
                ps.setString(3, persona.getApellidos());
                ps.setDate  (4, Conversiones.getFecha(Conversiones.getFecha(persona.getFechaNac())));
                ps.setString(5, persona.getEmail());
                ps.setInt   (6, persona.getTipoId().getId());
                ps.setInt   (7, persona.getSexo().getId());
                ps.setInt   (8, persona.getNacionalidad().getId());
                ps.setInt   (9, id);
                ps.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
