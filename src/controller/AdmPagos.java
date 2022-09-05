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
import controllerDAO.AdmPromocionesDAO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Anfitrion;
import model.Habitacion;
import model.Huesped;
import model.Pago;
import model.PromocionHabitacion;
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
        if (Validaciones.vDouble(precio) && codHab != null) {
            int codigoHabt = PagosArrayListsFK.getIdHabitacion(Integer.parseInt(codHab), idVivienda);
            p = new Pago(Double.parseDouble(precio), dtcFechaInicio.getDate(), dtcFechaFin.getDate(), "PAGADO", metPago, idHuesp, codigoHabt, idVivienda);
            if (Validaciones.vPagoFechas(p) && Validaciones.vPago(p)) {
                System.out.println(p.toString());
                return true;
            }
        }
        return false;
    }

    public static void insertarRegistro() {
        AdmPagosDAO.insertar(p);
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

    public static void limpiarCampos(JTextField txtIdHuesped) {
        txtIdHuesped.setText("");
    }

    public static int getIndexTable(JTable tblPromo) {
        return tblPromo.getSelectedRow();
    }

    public static void actualizarTabla(JTable tblPromo) {
        tamanoColumnasTabla(tblPromo);
        ArrayList<PromocionHabitacion> lista = AdmPromocionesDAO.consultarPromoHabitacion();
        DefaultTableModel model = (DefaultTableModel) tblPromo.getModel();
        model.setRowCount(0);
        /* Insertar registros a la tabla del formulario */
        for (PromocionHabitacion x : lista) {
            Object[] rowData = new Object[4];
            rowData[0] = x.getNombreVivienda();
            rowData[1] = x.getCodigoHabitacion();
            rowData[2] = x.getPrecio();
            rowData[3] = x.getPrecioTotal();
            model.addRow(rowData);
        }
    }

    /* Modificar el ancho de las columnas de la tabla */
    public static void tamanoColumnasTabla(JTable tblPersonas) {
        int[] anchos = {7, 70, 90, 70, 30, 7, 7};
        for (int i = 0; i < tblPersonas.getColumnCount(); i++) {
            tblPersonas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
}
