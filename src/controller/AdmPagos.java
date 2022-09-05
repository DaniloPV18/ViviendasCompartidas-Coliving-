/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import arraylists.HuespedArrayListsFK;
import arraylists.ViviendaArrayListsFK;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Anfitrion;
import model.Habitacion;
import model.Pago;

/**
 *
 * @author NILOXD
 */
public class AdmPagos {

    private static Pago p = null;

    public static boolean validarDatos(String idHuesped, String nombreVivienda, String codHab, String metodoPago, String dinero, String codHab0, JDateChooser dtcFechaInicio, JDateChooser dtcFechaFin) {
        /* Obtener las llaves foráneas de los combobox a través de los ArrayList */
        int idHuesp = HuespedArrayListsFK.getHuespedFK(idHuesped);
        int idVivienda = ViviendaArrayListsFK.getViviendaPK(ViviendaArrayListsFK.getViviendaIdentificador(nombreVivienda));
        int codigoHabt = Integer.parseInt(codHab);
        /* Validar que los datos ingresados sean los solicitados */
        p = new Pago(metodoPago, idHuesp, fechaInicio, fechaFinal, dinero, codigoHabt, idHuesp, codigoHabt, codigoHabt, idVivienda);
//        if (Validaciones.vAnfitrion(p)) {
//            return true;
//        }
        return false;
    }

    public static void cargarAnfitrion(String identificadorHuesped, JTextField txtNombreHuesped) {
        Anfitrion x = AdmAnfitriones.buscarCedula(identificadorHuesped);
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
