/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import arraylists.HuespedArrayListsFK;
import arraylists.PagosArrayListsFK;
import arraylists.ViviendaArrayListsFK;
import com.toedter.calendar.JDateChooser;
import controllerDAO.AdmPagosDAO;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Anfitrion;
import model.Habitacion;
import model.Huesped;
import model.Pago;
import utilities.Validaciones;

/**
 *
 * @author NILOXD
 */
public class AdmPagos {

    private static Pago p = null;

    public static boolean validarDatos(String idHuesped, String nombreVivienda, String codHab, String metodoPago, String precio, JDateChooser dtcFechaInicio, JDateChooser dtcFechaFin) {
        /* Obtener las llaves foráneas de los combobox a través de los ArrayList */
        int idHuesp = HuespedArrayListsFK.getHuespedFK(idHuesped);
        int idVivienda = ViviendaArrayListsFK.getViviendaPK(ViviendaArrayListsFK.getViviendaIdentificador(nombreVivienda));
//        int codigoHabt = Integer.parseInt(codHab);
        int metPago = PagosArrayListsFK.getMetodoPagoFK(metodoPago);
        /* Validar que los datos ingresados sean los solicitados */
        if (Validaciones.vDouble(precio) && codHab!=null) {
            int codigoHabt = Integer.parseInt(codHab);
            p = new Pago(Double.parseDouble(precio), dtcFechaInicio.getDate(), dtcFechaFin.getDate(), "PAGADO", metPago, idHuesp, codigoHabt, idVivienda);
            if (Validaciones.vPagoFechas(p) && Validaciones.vPago(p)) {
                System.out.println(p.toString());
                return true;
            }
        }
        return false;
    }

    public static void insertarRegistro() {
//        AdmPagosDAO.insertar(p);
    }

    public static void cargarHuesped(String identificadorHuesped, JTextField txtNombreHuesped) {
        Huesped x = AdmHuespedes.buscarCedula(identificadorHuesped);
        if (x != null) {
            txtNombreHuesped.setForeground(Color.BLACK);
            txtNombreHuesped.setText(x.getNombres() + " " + x.getApellidos());
        } else {
            txtNombreHuesped.setForeground(Color.RED);
            txtNombreHuesped.setText("NO SE HA ENCONTRADO");
        }
    }

    public static int getIndexTable(JTable tblPromo) {
        return tblPromo.getSelectedRow();
    }

    public static void cargarPrecio(String codigoHabt, String nombreVivienda, JTextField txtPrecioHabt, JTextField txtPrecioFinal) {
        String identificadorVivienda = ViviendaArrayListsFK.getViviendaIdentificador(nombreVivienda);
        if (identificadorVivienda != null) {
            Habitacion h = AdmHabitaciones.buscarHabitacion(identificadorVivienda, codigoHabt);
            txtPrecioHabt.setText(h.getPrecio() + "");
            txtPrecioFinal.setText(((Double.parseDouble(txtPrecioHabt.getText()) * 0.12) + (Double.parseDouble(txtPrecioHabt.getText()))) + " ");
        } else {
            txtPrecioHabt.setText("-");
            txtPrecioFinal.setText("-");
        }
    }

}
