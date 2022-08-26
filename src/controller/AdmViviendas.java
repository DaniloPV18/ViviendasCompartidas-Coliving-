/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import arraylists.ViviendaArrayListsFK;
import static controller.AdmAnfitriones.buscarCedula;
import controllerDB.AdmViviendasDAO;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Anfitrion;
import model.Vivienda;
import utilities.Conversiones;
import utilities.Validaciones;

/**
 *
 * @author N1L0XD
 */
public class AdmViviendas {

    private static Vivienda p = null;

    public static boolean validarDatos(String identificador, String nombre, String email, String direccion, String numHab, String anfitrion, String tipoVivienda) {
        /* Obtener las llaves foráneas de los combobox a través de los ArrayList */
        if (Validaciones.vInt(numHab)) {
            int idAnfitrion = ViviendaArrayListsFK.getAnfitrionFK(anfitrion);
            int idTipoVivienda = ViviendaArrayListsFK.getTipoViviendaFK(tipoVivienda);

            /* Validar que los datos ingresados sean los solicitados */
            p = new Vivienda(identificador, nombre, email, direccion,
                    Integer.parseInt(numHab), idAnfitrion, idTipoVivienda, 1, 1);
            if (Validaciones.vVivienda(p)) {
                p = Conversiones.viviendaUpperCase(p);
                return true;
            }
            return false;
        }
        return false;
    }

    /* Insertar registro a la Base de datos */
    public static void insertarRegistro() {
        AdmViviendasDAO.insertar(p);
    }

    /* Actualizar registro a la Base de datos */
    public static void actualizarRegistro(String identificadorPersona) {
        AdmViviendasDAO.actualizar(identificadorPersona, p);
    }

    /* Eliminar registro a la Base de datos */
    public static void eliminarRegistro(String identificadorPersona, int indice) {
        AdmViviendasDAO.eliminar(identificadorPersona);
    }

    /* Limpiar los campos del formulario */
    public static void limpiarCampos(JTextField txtCedula, JTextField txtNombres, JTextField txtApellidos, JTextField txtEmail, JTextField txtNumHabt) {
        txtCedula.setText(" ");
        txtNombres.setText(" ");
        txtApellidos.setText(" ");
        txtNumHabt.setText(" ");
    }

    /* Metodo para actualizar los registros de la tabla del formulario */
    public static void actualizarTabla(JTable tblPersonas) {
        tamanoColumnasTabla(tblPersonas);
        ArrayList<Vivienda> lista = AdmViviendasDAO.consultar();
        DefaultTableModel model = (DefaultTableModel) tblPersonas.getModel();
        model.setRowCount(0);
        /* Insertar registros a la tabla del formulario */
        for (Vivienda x : lista) {
            Object[] rowData = new Object[7];
            rowData[0] = x.getIdentificador();
            rowData[1] = x.getNombre();
            rowData[2] = x.getEmail();
            rowData[3] = x.getDireccion();
            rowData[4] = ViviendaArrayListsFK.getAnfitrion(x.getAnfitrion());
            rowData[5] = ViviendaArrayListsFK.getCiudad(x.getCiudad());
            rowData[6] = ViviendaArrayListsFK.getTipoVivienda(x.getTipoVivienda());
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

    /* Obtener la fila seleccionada de la tabla del formulario */
    public static int getIndexTable(JTable tblPersonas) {
        int indice = tblPersonas.getSelectedRow();
        return indice;
    }

    /* Obtener el identificador de la fila seleccionada de la tabla del formulario */
    public static String getIdentificador(JTable tblPersonas, int indice) {
        int row = tblPersonas.getSelectedRow();
        String value = tblPersonas.getModel().getValueAt(indice, 0).toString();
        return value;
    }

    /* Cargar los datos de la fila seleccionada y actualizar el formulario */
    public static void cargarRegistro(String identificadorVivienda, JTextField txtIDVivienda, JTextField txtNombreVivienda, JTextField txtEmail, JTextField txtDireccion, JTextField txtNumHabt, JComboBox<String> cmbCedulaPropietario, JComboBox<String> cmbCiudad, JComboBox<String> cmbTipoVivienda) {
        Vivienda x = buscarVivienda(identificadorVivienda);
        txtIDVivienda.setText(x.getIdentificador());
        txtNombreVivienda.setText(x.getNombre());
        txtEmail.setText(x.getEmail());
        txtDireccion.setText(x.getDireccion());
        txtNumHabt.setText(x.getNumHab() + "");
        cmbCedulaPropietario.setSelectedIndex(x.getAnfitrion() - 1);
        cmbCiudad.setSelectedIndex(x.getCiudad() - 1);
        cmbTipoVivienda.setSelectedIndex(x.getTipoVivienda() - 1);
    }

    /* Cargar los datos de la anfitrion de la vivienda seleccionada */
    public static void cargarAnfitrion(String identificadorVivienda, JTextField txtAnfitrion) {
        Vivienda x = buscarVivienda(identificadorVivienda);
        Anfitrion o = buscarCedula(ViviendaArrayListsFK.getAnfitrion(x.getAnfitrion()));
        txtAnfitrion.setText(o.getNombres() + " " + o.getApellidos());
    }

    /* Buscar una cedula que se encuentre registrada */
    public static Vivienda buscarVivienda(String identificador) {
        ArrayList<Vivienda> lista = AdmViviendasDAO.consultar();
        for (Vivienda x : lista) {
            if (x.getIdentificador().compareToIgnoreCase(identificador) == 0) {
                return x;
            }
        }
        return null;
    }

}
