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
import model.Nacionalidad;
import model.Sexo;
import model.TipoIdentificacion;

/**
 *
 * @author N1L0XD
 */
public class Servicios {
    
    private static final Connection cn = Conexion.getConnection();
    
    private static final String LISTARSEXO          = "SELECT * FROM sexo WHERE estado = 'HABILITADO' ";
    private static final String LISTARNACIONALIDAD  = "SELECT * FROM nacionalidad WHERE estado = 'HABILITADO' ";
    private static final String LISTARTIPOID        = "SELECT * FROM tipoidentificacion WHERE estado = 'HABILITADO' ";
    
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
        for (Nacionalidad nacionalidad : lista) {
            System.out.println(nacionalidad.toString());
        }
        return lista;
    }
    
    public static ArrayList<TipoIdentificacion> consultarTTipoId() {
        ArrayList<TipoIdentificacion> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARTIPOID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    TipoIdentificacion o = new TipoIdentificacion(
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
}
