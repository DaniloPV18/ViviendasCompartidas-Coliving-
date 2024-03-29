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
import model.Pago;
import utilities.Conversiones;

/**
 *
 * @author N1L0XD
 */
public class AdmPagosDAO {

    private static final Connection cn = Conexion.getConnection();

    private static final String INSERTAR_DIRECTO = "  INSERT INTO pagos ("
            + "     monto_usuario, fecha_reg, fecha_inicio , fecha_final, estado, pago_metodo_id_pago_metodo, huesped_id_huesped, pago_tipo_id_pago_tipo"
            + "     ,habitacion_id_habitacion, habitacion_vivienda_id_vivienda "
            + ")VALUES(?,?,?,?,?,?,?,?,?,?)";

    private static final String INSERTAR_RESERVA = "  INSERT INTO pagos ("
            + "     monto_usuario, fecha_reg, fecha_inicio , fecha_final, estado, pago_metodo_id_pago_metodo, huesped_id_huesped, pago_tipo_id_pago_tipo"
            + "     ,habitacion_id_habitacion, habitacion_vivienda_id_vivienda, identificador "
            + ")VALUES(?,?,?,?,?,?,?,?,?,?,?)";

//    private static final String ACTUALIZAR = " UPDATE pago "
//            + "SET "
//            + "     identificador = ?, nombres = ?, apellidos = ?, fecha_nac = ?, email = ?, "
//            + "     identificacion_tipo_id_identificacion_tipo = ?, sexo_id_sexo = ?, nacionalidad_id_nacionalidad = ? "
//            + "WHERE identificador = ? ";
//    
//    private static final String ELIMINAR = " UPDATE pago "
//            + "SET "
//            + "     estado = ?"
//            + "WHERE identificador = ? ";
    private static final String LISTAR_PAGADOS = " SELECT * FROM pagos WHERE estado = 'PAGADO' ";
    
    private static final String LISTAR_RESERVAS = " SELECT * FROM pagos WHERE pago_tipo_id_pago_tipo = 2 and identificador = ?";

    public static Connection getCn() {
        return cn;
    }

    //Insertar registro en BD 
    public static void insertar(Pago pago) {
        if (cn != null) {
            switch (pago.getTipoPago()) {
                case 1:
                    insertarDirecto(pago);
                    break;
                case 2:
                    insertarReserva(pago);
                    break;
            }
        }
    }

    private static void insertarDirecto(Pago pago) {
        try {
            PreparedStatement ps = cn.prepareStatement(INSERTAR_DIRECTO);
            ps.setDouble(1, pago.getMonto());
            ps.setTimestamp(2, Conversiones.getFecha(Conversiones.getFecha(pago.getFechaReg())));
            ps.setTimestamp(3, Conversiones.getFecha(Conversiones.getFecha(pago.getFechaInicio())));
            ps.setTimestamp(4, Conversiones.getFecha(Conversiones.getFecha(pago.getFechaFinal())));
            ps.setString(5, pago.getEstado());
            ps.setInt(6, pago.getMetodoPago());
            ps.setInt(7, pago.getHuesped());
            ps.setInt(8, pago.getTipoPago());
            ps.setInt(9, pago.getHabitacion());
            ps.setInt(10, pago.getPropiedad());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Datos han sido insertados.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private static void insertarReserva(Pago pago) {
        try {
            PreparedStatement ps = cn.prepareStatement(INSERTAR_RESERVA);
            ps.setDouble(1, pago.getMonto());
            ps.setTimestamp(2, Conversiones.getFecha(Conversiones.getFecha(pago.getFechaReg())));
            ps.setTimestamp(3, Conversiones.getFecha(Conversiones.getFecha(pago.getFechaInicio())));
            ps.setTimestamp(4, Conversiones.getFecha(Conversiones.getFecha(pago.getFechaFinal())));
            ps.setString(5, pago.getEstado());
            ps.setInt(6, pago.getMetodoPago());
            ps.setInt(7, pago.getHuesped());
            ps.setInt(8, pago.getTipoPago());
            ps.setInt(9, pago.getHabitacion());
            ps.setInt(10, pago.getPropiedad());
            ps.setString(11, pago.getIdentificador());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Datos han sido insertados.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Actualizar registro en BD 
//    public static void actualizar(String identificadorPago, Pago pago) {
//        System.out.println(identificadorPago + " " + pago.toString());
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(ACTUALIZAR);
//                ps.setString(1, pago.getIdentificador());
//                ps.setString(2, pago.getNombres());
//                ps.setString(3, pago.getApellidos());
//                ps.setTimestamp(4, Conversiones.getFecha(Conversiones.getFecha(pago.getFechaNac())));
//                ps.setString(5, pago.getEmail());
//                ps.setInt(6, pago.getTipoId());
//                ps.setInt(7, pago.getSexo());
//                ps.setInt(8, pago.getNacionalidad());
//                ps.setString(9, identificadorPago);
//                ps.execute();
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//        }
//    }
    //Eliminado logico en BD 
//    public static void eliminar(String cedula){
//        String newEstado = "ELIMINADO";
//        if (cn != null) {
//            try {
//                PreparedStatement ps = cn.prepareStatement(ELIMINAR);
//                ps.setString(1, newEstado);
//                ps.setString(2, cedula);
//                ps.execute();
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//        }
//    }
    //Consulta de los registros almacenados en la tabla de la BD
    public static ArrayList<Pago> consultar() {
        ArrayList<Pago> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTAR_PAGADOS);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Pago p = new Pago(
                            rs.getDouble(2),
                            rs.getDate(4),
                            rs.getDate(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getInt(11)
                    );
                    p.setId(rs.getInt(1));
                    p.setFechaReg(rs.getTimestamp(3));
                    lista.add(p);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }
    
    public static ArrayList<Pago> consultarReservas(String identificadorReserva) {
        ArrayList<Pago> lista = new ArrayList<>();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(LISTAR_RESERVAS);
                ps.setString(1, identificadorReserva);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Pago p = new Pago(
                            rs.getString(13),
                            rs.getDouble(2),
                            rs.getDate(4),
                            rs.getDate(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getInt(11)
                    );
                    p.setId(rs.getInt(1));
                    p.setFechaReg(rs.getTimestamp(3));
                    lista.add(p);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return lista;
    }

}
