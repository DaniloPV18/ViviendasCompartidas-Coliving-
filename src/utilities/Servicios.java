/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author N1L0XD
 */
public class Servicios {
    
    private static final Connection cn = Conexion.getConnection();
    
    private static final String LISTARSEXO          = "SELECT * FROM sexo WHERE estado = 'HABILITADO' ";
    private static final String LISTARNACIONALIDAD  = "SELECT * FROM nacionalidad WHERE estado = 'HABILITADO' ";
    private static final String LISTARTIPOID        = "SELECT * FROM identificacion_tipo WHERE estado = 'HABILITADO' ";
    
    private static final String LISTARANFITRION        = "SELECT * FROM anfitrion WHERE estado = 'HABILITADO' ";
    private static final String LISTARCIUDAD           = "SELECT * FROM ciudad WHERE estado = 'HABILITADO' ";
    private static final String LISTARVIVIENDATIPO     = "SELECT * FROM vivienda_tipo WHERE estado = 'HABILITADO' ";
    
    public static void ActualizarListas(){
        consultarTSexo();
        consultarTTipoId();
        consultarTNacionalidad();
    }
    
    public static ArrayList<Sexo> consultarTSexo() {
        ArrayList<Sexo> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARSEXO);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Sexo o = new Sexo(
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                    );
                    o.setFechaReg(rs.getTimestamp(5));
                    o.setId(rs.getInt(1));
                    lista.add(o);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }
    
    public static ArrayList<Nacionalidad> consultarTNacionalidad() {
        ArrayList<Nacionalidad> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARNACIONALIDAD);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Nacionalidad o = new Nacionalidad(
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                    );
                    o.setFechaReg(rs.getTimestamp(5));
                    o.setId(rs.getInt(1));
                    lista.add(o);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }
    
    public static ArrayList<IdentificacionTipo> consultarTTipoId() {
        ArrayList<IdentificacionTipo> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARTIPOID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    IdentificacionTipo o = new IdentificacionTipo(
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                    );
                    o.setFechaReg(rs.getTimestamp(5));
                    o.setId(rs.getInt(1));
                    lista.add(o);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }

    public static ArrayList<Anfitrion> consultarTAnfitrion() {
        ArrayList<Anfitrion> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARTIPOID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Anfitrion o = new Anfitrion(
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                    );
                    o.setFechaReg(rs.getTimestamp(5));
                    o.setId(rs.getInt(1));
                    lista.add(o);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }

    public static ArrayList<Ciudad> consultarTCiudad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList<ViviendaTipo> consultarTViviendaTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
