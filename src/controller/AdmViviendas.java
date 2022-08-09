/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import arraylists.ViviendaArrayListsFK;
import com.toedter.calendar.JDateChooser;
import controllerDB.AdmViviendasDataBase;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
                    Integer.parseInt(numHab), idAnfitrion, idTipoVivienda, 1,1);
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
        AdmViviendasDataBase.insertar(p);
    }

    /* Actualizar registro a la Base de datos */
    public static void actualizarRegistro(String identificadorPersona) {
        AdmViviendasDataBase.actualizar(identificadorPersona, p);
    }

    /* Eliminar registro a la Base de datos */
    public static void eliminarRegistro(String identificadorPersona, int indice) {
        AdmViviendasDataBase.eliminar(identificadorPersona);
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
        ArrayList<Vivienda> lista = AdmViviendasDataBase.consultar();
        DefaultTableModel model = (DefaultTableModel) tblPersonas.getModel();
        model.setRowCount(0);
        /* Insertar registros a la tabla del formulario */
        for (Vivienda x : lista) {
            Object[] rowData = new Object[5];
//            rowData[0] = x.getIdentificador();
//            rowData[1] = x.getNombres();
//            rowData[2] = x.getApellidos();
//            rowData[3] = PersonaArrayListsFK.getIdentificacionTipo(x.getTipoId());
//            rowData[4] = PersonaArrayListsFK.getSexo(x.getSexo());
            model.addRow(rowData);
        }
    }

    /* Modificar el ancho de las columnas de la tabla */
    public static void tamanoColumnasTabla(JTable tblPersonas) {
        int[] anchos = {6, 70, 70, 150, 10, 10, 10, 10, 10};
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
    public static void cargarRegistro(String identificador, JTextField txtCedula, JTextField txtNombres, JTextField txtApellidos, JTextField txtEmail, JDateChooser dtcFechaNac, JComboBox<String> cmbSexo, JComboBox<String> cmbTipoId, JComboBox<String> cmbNacionalidad) {
        Vivienda x = buscarVivienda(identificador);
//        txtCedula.setText(x.getIdentificador());
//        txtNombres.setText(x.getNombres());
//        txtApellidos.setText(x.getApellidos());
//        txtEmail.setText(x.getEmail());
//        cmbNacionalidad.setSelectedIndex(x.getNacionalidad() - 1);
//        cmbSexo.setSelectedIndex(x.getSexo() - 1);
//        cmbTipoId.setSelectedIndex(x.getTipoId() - 1);
//        dtcFechaNac.setDate(Conversiones.getDate(x.getFechaNac().toString()));
    }

    /* Buscar una cedula que se encuentre registrada */
    public static Vivienda buscarVivienda(String identificador) {
        ArrayList<Vivienda> lista = AdmViviendasDataBase.consultar();
        for (Vivienda x : lista) {
            if (x.getIdentificador().compareToIgnoreCase(identificador) == 0) {
                return x;
            }
        }
        return null;
    }

}
