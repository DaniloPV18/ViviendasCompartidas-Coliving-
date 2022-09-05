/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import arraylists.HabitacionArrayListsFK;
import arraylists.ViviendaArrayListsFK;
import controllerDAO.AdmHabitacionesDAO;
import controllerDAO.AdmViviendasDAO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Habitacion;
import model.Vivienda;
import utilities.Validaciones;

/**
 *
 * @author N1L0XD
 */
public class AdmHabitaciones {

    private static Habitacion p = null;

    public static boolean validarDatos(String idVivienda, String identificador, String max, boolean bano, String precio) {
        /* Obtener las llaves foráneas de los combobox a través de los ArrayList */
        int idViviend = ViviendaArrayListsFK.getViviendaPK(idVivienda);

        if (Validaciones.vDouble(precio) && Validaciones.vInt(identificador)) {
            if(max.compareToIgnoreCase("") == 0){
                max = "1";
            }
            double prc = Double.parseDouble(precio);
            int maxP = Integer.parseInt(max);
            int tipoHb = Integer.parseInt(max) < 2 ? 1 : 2;
            int identificadorHabitacion = Integer.parseInt(identificador);

            /* Validar que los datos ingresados sean los solicitados */
            p = new Habitacion(identificadorHabitacion, maxP, bano, prc, tipoHb, idViviend, 1, 1);
            if (Validaciones.vHabitacion(p)) {
                System.out.println(p.toString());
                return true;
            }
        }
        return false;
    }

    /* Insertar registro a la Base de datos */
    public static void insertarRegistro() {
        AdmHabitacionesDAO.insertar(p);
    }

    /* Actualizar registro a la Base de datos */
    public static void actualizarRegistro(String identificadorHb) {
        AdmHabitacionesDAO.actualizar(Integer.parseInt(identificadorHb), p);
    }

    /* Eliminar registro a la Base de datos */
    public static void eliminarRegistro(String identificadorPersona, int indice) {
        AdmHabitacionesDAO.eliminar(identificadorPersona);
    }

    /* Limpiar los campos del formulario */
    public static void limpiarCampos(JTextField txtIdentificador, JTextField txtCodHabt, JTextField txtNumMaxHbt, JTextField txtPrecio, JCheckBox chcBano) {
        txtIdentificador.setText(" ");
        txtCodHabt.setText(" ");
        txtNumMaxHbt.setText(" ");
        txtPrecio.setText(" ");
        chcBano.setSelected(false);
    }

    /* Metodo para actualizar los registros de la tabla del formulario */
    public static void actualizarTabla(JTable tabla) {
        tamanoColumnasTabla(tabla);
        ArrayList<Habitacion> lista = AdmHabitacionesDAO.consultar();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        /* Insertar registros a la tabla del formulario */
        for (Habitacion x : lista) {
            Object[] rowData = new Object[7];
            rowData[0] = x.getIdentificador();
            rowData[1] = x.getNumMax();
            rowData[2] = x.getBanios() == true ? "SI" : "NO";
            rowData[3] = x.getPrecio();
            rowData[4] = HabitacionArrayListsFK.getHabitacionTipo(x.getTipoHab());
            rowData[5] = HabitacionArrayListsFK.getVivienda(x.getPropiedad());
            model.addRow(rowData);
        }
    }

    /* Modificar el ancho de las columnas de la tabla */
    public static void tamanoColumnasTabla(JTable tabla) {
        int[] anchos = {7, 70, 90, 70, 30, 7, 7};
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    /* Obtener la fila seleccionada de la tabla del formulario */
    public static int getIndexTable(JTable tabla) {
        int indice = tabla.getSelectedRow();
        return indice;
    }

    /* Obtener el identificador de la fila seleccionada de la tabla del formulario */
    public static String getIdentificador(JTable tabla, int indice) {
        int row = tabla.getSelectedRow();
        String value = tabla.getModel().getValueAt(indice, 0).toString();
        return value;
    }

    public static String getIdentificadorVivienda(JTable tabla, int indice) {
        int row = tabla.getSelectedRow();
        String value = tabla.getModel().getValueAt(indice, 5).toString();
        return value;
    }

    /* Cargar los datos de la fila seleccionada y actualizar el formulario */
    public static void cargarRegistro(String identificadorHabitacion, String idVivienda, JTextField txtIdentificador, JTextField txtCodHabt, JTextField txtNumMaxHbt, JTextField txtPrecio, JCheckBox chcBano) {
        Vivienda x = buscarVivienda(idVivienda);
        Habitacion h = buscarHabitacion(idVivienda, identificadorHabitacion);
        txtIdentificador.setText(x.getIdentificador());
        txtCodHabt.setText(h.getIdentificador() + " ");
        txtPrecio.setText(h.getPrecio() + " ");
        txtNumMaxHbt.setText(h.getNumMax()+ " ");
        chcBano.setSelected(h.getBanios());
    }

    public static void cargarVivienda(String idVivienda, JTextField txtNombrePrp) {
        Vivienda x = buscarVivienda(idVivienda);
        txtNombrePrp.setText(x.getNombre());
    }

    /* Cargar los datos de la anfitrion de la vivienda seleccionada */
    public static void cargarAnfitrion(String identificador, JTextField txtAnfitrion) {
        Vivienda x = buscarVivienda(identificador);
        if (x != null) {
            txtAnfitrion.setForeground(Color.BLACK);
            txtAnfitrion.setText(x.getNombre());
        } else {
            txtAnfitrion.setForeground(Color.RED);
            txtAnfitrion.setText("NO SE HA ENCONTRADO");
        }
    }

    /* Buscar una Vivienda que se encuentre registrada */
    public static Vivienda buscarVivienda(String identificadorVivienda) {
        ArrayList<Vivienda> lista = AdmViviendasDAO.consultar();
        for (Vivienda x : lista) {
            if (x.getIdentificador().compareToIgnoreCase(identificadorVivienda) == 0) {
                return x;
            }
        }
        return null;
    }

    public static Habitacion buscarHabitacion(String identificadorVivienda, String identificadorHabitacion) {
        Vivienda v = buscarVivienda(identificadorVivienda);
        if (v != null) {
            ArrayList<Habitacion> lista = AdmHabitacionesDAO.consultar();
            for (Habitacion x : lista) {
                if (x.getIdentificador() == Integer.parseInt(identificadorHabitacion)) {
                    return x;
                }
            }
        }
        return null;
    }

}
