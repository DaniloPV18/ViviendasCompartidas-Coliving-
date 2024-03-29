/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import arraylists.ViviendaArrayListsFK;
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
    
    private static final String LISTARANFITRION        = "SELECT a.id_anfitrion, a.id_persona, a.estado, a.fecha_reg, p.identificador FROM anfitrion a "
                                                            + "INNER JOIN persona p ON a.id_persona = p.id_persona AND a.estado = 'HABILITADO' AND p.estado = 'HABILITADO' ";
    private static final String LISTARCIUDAD           = "SELECT * FROM ciudad WHERE estado = 'HABILITADO' ";
    private static final String LISTARVIVIENDATIPO     = "SELECT * FROM vivienda_tipo WHERE estado = 'HABILITADO' ";
    private static final String LISTARHABITACIONTIPO   = "SELECT * FROM habitacion_tipo WHERE estado = 'HABILITADO' ";
    private static final String LISTARPAGOTIPO         = "SELECT * FROM pago_tipo WHERE estado = 'HABILITADO' ";
    private static final String LISTARPAGOMETODOS      = "SELECT * FROM pago_metodo WHERE estado = 'HABILITADO' ";
    private static final String LISTARCODHAB           = " SELECT * FROM habitacion "
                                                            + " WHERE (habitacion_estado_id_habitacion_estado = 1 or "
                                                            + " habitacion_estado_id_habitacion_estado = 3) AND vivienda_id_vivienda = ? ";
    
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
                            rs.getString(3)
                    );
                    o.setFechaReg(rs.getTimestamp(4));
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
                            rs.getString(4)
                    );
                    o.setFechaReg(rs.getTimestamp(3));
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
                            rs.getString(3)
                    );
                    o.setFechaReg(rs.getTimestamp(4));
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
        ArrayList<Ciudad> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARCIUDAD);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Ciudad o = new Ciudad(
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(5)
                    );
                    o.setFechaReg(rs.getTimestamp(4));
                    o.setId(rs.getInt(1));
                    lista.add(o);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }

    public static ArrayList<ViviendaTipo> consultarTViviendaTipo() {
        ArrayList<ViviendaTipo> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARVIVIENDATIPO);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ViviendaTipo o = new ViviendaTipo(
                            rs.getString(2),
                            rs.getString(3)
                    );
                    o.setFechaReg(rs.getTimestamp(4));
                    o.setId(rs.getInt(1));
                    lista.add(o);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }
    public static ArrayList<HabitacionTipo> consultarTHabitacionTipo() {
        ArrayList<HabitacionTipo> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARHABITACIONTIPO);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    HabitacionTipo o = new HabitacionTipo(
                            rs.getString(2),
                            rs.getString(3)
                    );
                    o.setFechaReg(rs.getTimestamp(4));
                    o.setId(rs.getInt(1));
                    lista.add(o);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }

    public static ArrayList<PagoTipo> consultarTPagoTipo() {
        ArrayList<PagoTipo> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARPAGOTIPO);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    PagoTipo o = new PagoTipo(
                            rs.getString(2),
                            rs.getString(3)
                    );
                    o.setFechaReg(rs.getTimestamp(4));
                    o.setId(rs.getInt(1));
                    lista.add(o);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }

    public static ArrayList<PagoMetodo> consultarTPagoMetodo() {
        ArrayList<PagoMetodo> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARPAGOMETODOS);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    PagoMetodo o = new PagoMetodo(
                            rs.getString(2),
                            rs.getString(3)
                    );
                    o.setFechaReg(rs.getTimestamp(4));
                    o.setId(rs.getInt(1));
                    lista.add(o);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }

    public static ArrayList<Habitacion> consultarHabitaciones(String nombreVivienda) {
        int idVivienda = ViviendaArrayListsFK.getViviendaPK(ViviendaArrayListsFK.getViviendaIdentificador(nombreVivienda));
        ArrayList<Habitacion> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTARCODHAB);
                ps.setInt(1, idVivienda);
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
