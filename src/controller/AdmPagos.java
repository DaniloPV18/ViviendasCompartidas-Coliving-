/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import arraylists.HabitacionArrayListsFK;
import arraylists.HuespedArrayListsFK;
import arraylists.PagosArrayListsFK;
import arraylists.ViviendaArrayListsFK;
import com.toedter.calendar.JDateChooser;
import controllerDAO.AdmPagosDAO;
import controllerDAO.AdmPromocionesDAO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
    private static ArrayList<Pago> listaReservas = null;

    public static ArrayList<Pago> getListaReservas() {
        return listaReservas;
    }

    public static void setListaReservas(ArrayList<Pago> listaReservas) {
        AdmPagos.listaReservas = listaReservas;
    }

    public static boolean validarDatos(String idHuesped, String nombreVivienda, String codHab, String metodoPago, String precio, JDateChooser dtcFechaInicio, JDateChooser dtcFechaFin, int tipoPago) {
        /* Obtener las llaves foráneas de los combobox a través de los ArrayList */
        int idHuesp = HuespedArrayListsFK.getHuespedFK(idHuesped);
        int idVivienda = ViviendaArrayListsFK.getViviendaPK(ViviendaArrayListsFK.getViviendaIdentificador(nombreVivienda));
//        int codigoHabt = Integer.parseInt(codHab);
        int metPago = PagosArrayListsFK.getMetodoPagoFK(metodoPago);
        /* Validar que los datos ingresados sean los solicitados */
        if (Validaciones.vDouble(precio) && codHab != null) {
            int codigoHabt = PagosArrayListsFK.getIdHabitacion(Integer.parseInt(codHab), idVivienda);
            p = new Pago(Double.parseDouble(precio), dtcFechaInicio.getDate(), dtcFechaFin.getDate(), "PAGADO", metPago, idHuesp, tipoPago, codigoHabt, idVivienda);
            if (Validaciones.vPagoFechas(p) && Validaciones.vPago(p)) {
                System.out.println(p.toString());
                return true;
            }
        }
        return false;
    }

    public static boolean validarDatos(String identificadorRs, String idHuesped, String nombreVivienda, String codHab, String metodoPago, String precio, JDateChooser dtcFechaInicio, JDateChooser dtcFechaFin, int tipoPago) {
        /* Obtener las llaves foráneas de los combobox a través de los ArrayList */
        int idHuesp = HuespedArrayListsFK.getHuespedFK(idHuesped);
        int idVivienda = ViviendaArrayListsFK.getViviendaPK(ViviendaArrayListsFK.getViviendaIdentificador(nombreVivienda));
//        int codigoHabt = Integer.parseInt(codHab);
        int metPago = PagosArrayListsFK.getMetodoPagoFK(metodoPago);
        /* Validar que los datos ingresados sean los solicitados */
        if (Validaciones.vDouble(precio) && codHab != null && !identificadorRs.isEmpty()) {
            int codigoHabt = PagosArrayListsFK.getIdHabitacion(Integer.parseInt(codHab), idVivienda);
            p = new Pago(identificadorRs, Double.parseDouble(precio), dtcFechaInicio.getDate(), dtcFechaFin.getDate(), "PAGADO", metPago, idHuesp, tipoPago, codigoHabt, idVivienda);
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

    public static void limpiarCampos(JTextField txtNombreHuesped, JTextField txtIdHuesped, JTextField txtPrecioHabt, JTextField txtPrecioFinal, JTextField txtReserva, JTextField txtMontoDeuda, JDateChooser dtcFechaInicio, JDateChooser dtcFechaFin) {
        txtNombreHuesped.setText("");
        txtIdHuesped.setText("");
        txtPrecioHabt.setText("");
        txtPrecioFinal.setText("");
        txtReserva.setText("");
        txtMontoDeuda.setText("");
        dtcFechaInicio.setDate(new java.util.Date());
        dtcFechaFin.setDate(new java.util.Date());
    }

    public static void limpiarCampos(JTextField txtNombreHuesped, JTextField txtIdHuesped, JTextField txtPrecioHabt, JTextField txtMontoDeuda, JTextField txtPrecioFinal) {
        txtNombreHuesped.setText("");
        txtIdHuesped.setText("");
        txtPrecioHabt.setText("");
        txtMontoDeuda.setText("");
        txtPrecioFinal.setText("");
    }

    public static int getIndexTable(JTable tblPromo) {
        return tblPromo.getSelectedRow();
    }

    /* Obtener el identificador de la fila seleccionada de la tabla del formulario */
    public static PromocionHabitacion getPromoHabitacion(JTable tblPersonas, int indice) {
        String nombre = tblPersonas.getModel().getValueAt(indice, 0).toString();
        String codigo = tblPersonas.getModel().getValueAt(indice, 1).toString();
        String precio = tblPersonas.getModel().getValueAt(indice, 2).toString();
        String precioDesc = tblPersonas.getModel().getValueAt(indice, 3).toString();
        String precioFinal = tblPersonas.getModel().getValueAt(indice, 4).toString();
        return new PromocionHabitacion(nombre, Integer.parseInt(codigo), Double.parseDouble(precio), Double.parseDouble(precioDesc), Double.parseDouble(precioFinal));
    }

    public static void cargarRegistro(JComboBox<String> cmbViviendaNombre, JComboBox<String> cmbCodHab, JTextField txtPrecioHabt, JTextField txtPrecioFinal, PromocionHabitacion ph) {
        cmbViviendaNombre.setSelectedItem(ph.getNombreVivienda());
        cmbCodHab.setSelectedItem(ph.getCodigoHabitacion() + "");
        txtPrecioHabt.setText(ph.getPrecioTotal() + "");
        txtPrecioFinal.setText(ph.getPrecioFinal() + "");
    }

    public static void cargarRegistro(JTextField txtNombreHuesped, JTextField txtIdHuesped, JComboBox<String> cmbViviendaNombre, JComboBox<String> cmbCodHab, JTextField txtPrecioHabt, JTextField txtMontoDeuda, JTextField txtAbono, JDateChooser dtcFechaInicio, JDateChooser dtcFechaFin) {
        Pago pg = getListaReservas().get(0);
        double totalAbonado = 0.0;
        for (Pago listaReserva : getListaReservas()) {
            totalAbonado += listaReserva.getMonto();
        }
        cargarHuesped(HuespedArrayListsFK.getHuespedFK(pg.getHuesped()), txtNombreHuesped);
        txtIdHuesped.setText(HuespedArrayListsFK.getHuespedFK(pg.getHuesped()));
        cmbViviendaNombre.setSelectedIndex(pg.getPropiedad() - 1);
        cmbCodHab.setSelectedItem(PagosArrayListsFK.getIdHabitacion(pg.getHabitacion(), pg.getPropiedad()));
        Habitacion h = AdmHabitaciones.buscarHabitacion(HabitacionArrayListsFK.getVivienda(pg.getPropiedad()), (String) cmbCodHab.getSelectedItem());
        dtcFechaInicio.setDate(pg.getFechaInicio());
        dtcFechaFin.setDate(pg.getFechaFinal());
        txtPrecioHabt.setText(h.getPrecio() + "");
        txtMontoDeuda.setText(Double.parseDouble(txtPrecioHabt.getText()) - totalAbonado + "");
        txtAbono.setText(totalAbonado + "");
//        txtPrecioFinal.setText(ph.getPrecioFinal() + "");
    }

    public static void actualizarTabla(JTable tblPromo) {
        tamanoColumnasTabla(tblPromo);
        ArrayList<PromocionHabitacion> lista = AdmPromocionesDAO.consultarPromoHabitacion();
        DefaultTableModel model = (DefaultTableModel) tblPromo.getModel();
        model.setRowCount(0);
        /* Insertar registros a la tabla del formulario */
        for (PromocionHabitacion x : lista) {
            Object[] rowData = new Object[5];
            rowData[0] = x.getNombreVivienda();
            rowData[1] = x.getCodigoHabitacion();
            rowData[2] = x.getPrecio();
            rowData[3] = x.getPrecioTotal();
            rowData[4] = x.getPrecioFinal();
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

    public static boolean existeReserva(String identificadorReserva) {
        ArrayList<Pago> lista = AdmPagosDAO.consultarReservas(identificadorReserva);
        return lista.size() >= 1;
    }

    public static void cargarReservas(String identificadorReserva) {
        setListaReservas(AdmPagosDAO.consultarReservas(identificadorReserva));
    }

    public static boolean validarCantidad(JTextField txtMontoDeuda, JTextField txtPrecioFinal) {
        double deuda = Double.parseDouble(txtMontoDeuda.getText().trim());
        double abono = Double.parseDouble(txtPrecioFinal.getText().trim());
        if(abono <= deuda){            
            return true;
        }
        JOptionPane.showMessageDialog(null, "El abono dado debe ser igual o menor a la deuda registrada.");
        return false;
    }
}
