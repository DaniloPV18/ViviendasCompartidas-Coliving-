/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import controllerDAO.AdmPromocionesDAO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Promocion;
import utilities.Conversiones;
import utilities.Validaciones;

/**
 *
 * @author N1L0XD
 */
public class AdmPromociones {

    private static Promocion p = null;

    public static boolean validarDatos(JDateChooser dtcFechaInicio, JDateChooser dtcFechaFin, String descuento) {
        /* Obtener las llaves foráneas de los combobox a través de los ArrayList */
        if (Validaciones.vInt(descuento)) {

            /* Validar que los datos ingresados sean los solicitados */
            p = new Promocion(dtcFechaInicio.getDate(), dtcFechaFin.getDate(), Integer.parseInt(descuento), "A");
            return Validaciones.vPromocion(p);
        }
        return false;
    }

    /* Insertar registro a la Base de datos */
    public static void insertarRegistro() {
        AdmPromocionesDAO.insertar(p);
    }

    /* Actualizar registro a la Base de datos */
    public static void actualizarRegistro(int identificadorPersona) {
        AdmPromocionesDAO.actualizar(identificadorPersona, p);
    }

    /* Eliminar registro a la Base de datos */
    public static void eliminarRegistro(int identificadorPersona, int indice) {
        AdmPromocionesDAO.eliminar(identificadorPersona);
    }

    /* Limpiar los campos del formulario */
    public static void limpiarCampos(JDateChooser dtcFechaInicio, JDateChooser dtcFechaFin, JTextField txtDescuento) {
        dtcFechaInicio.setDate(new Date(2000 - 1900, 0, 1));
        dtcFechaFin.setDate(new Date(2000 - 1900, 0, 1));
        txtDescuento.setText(" ");
    }

    /* Metodo para actualizar los registros de la tabla del formulario */
    public static void actualizarTabla(JTable tblPromociones) {
        tamanoColumnasTabla(tblPromociones);
        ArrayList<Promocion> lista = AdmPromocionesDAO.consultar();
        DefaultTableModel model = (DefaultTableModel) tblPromociones.getModel();
        model.setRowCount(0);
        /* Insertar registros a la tabla del formulario */
        for (Promocion x : lista) {
            Object[] rowData = new Object[7];
            rowData[0] = x.getId();
            rowData[1] = x.getFechaInicio();
            rowData[2] = x.getFechaFinal();
            rowData[3] = x.getDescuento();
            model.addRow(rowData);
        }
    }

    /* Modificar el ancho de las columnas de la tabla */
    public static void tamanoColumnasTabla(JTable tblPromociones) {
        int[] anchos = {7, 70, 90, 70, 30, 7, 7};
        for (int i = 0; i < tblPromociones.getColumnCount(); i++) {
            tblPromociones.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    /* Obtener la fila seleccionada de la tabla del formulario */
    public static int getIndexTable(JTable tblPromociones) {
        int indice = tblPromociones.getSelectedRow();
        return indice;
    }

    /* Obtener el identificador de la fila seleccionada de la tabla del formulario */
    public static int getIdentificador(JTable tblPromociones, int indice) {
        int row = tblPromociones.getSelectedRow();
        String value = tblPromociones.getModel().getValueAt(indice, 0).toString();
        return Integer.parseInt(value);
    }

    /* Cargar los datos de la fila seleccionada y actualizar el formulario */
    public static void cargarRegistro(int identificador, JDateChooser dtcFechaInicio, JDateChooser dtcFechaFin, JTextField txtDescuento) {
        Promocion x = buscarPromocion(identificador);
        txtDescuento.setText(x.getDescuento()+"");
        dtcFechaInicio.setDate(Conversiones.getDate(x.getFechaInicio().toString()));
        dtcFechaFin.setDate(Conversiones.getDate(x.getFechaFinal().toString()));        
    }

    /* Cargar los datos de la anfitrion de la vivienda seleccionada */
    public static Promocion buscarPromocion(int identificador) {
        ArrayList<Promocion> listaPersonas = AdmPromocionesDAO.consultar();
        for (Promocion x : listaPersonas) {
            if (x.getId() == identificador) {
                return x;
            }
        }
        return null;
    }

}
