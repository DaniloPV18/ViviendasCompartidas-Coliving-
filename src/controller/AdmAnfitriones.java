/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import arraylists.AnfitrionArrayListsFK;
import com.toedter.calendar.JDateChooser;
import controllerDAO.AdmAnfitrionesDAO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Anfitrion;
import utilities.Conversiones;
import utilities.Validaciones;

/**
 *
 * @author N1L0XD
 */
public class AdmAnfitriones {

    private static Anfitrion p = null;

    public static boolean validarDatos(String identificador, String nombres, String apellidos, String email, String fkSexo, String fkTipoID, String fkNacionalidad, JDateChooser dtcFechaNac) {
        /* Obtener las llaves foráneas de los combobox a través de los ArrayList */
        int idSexo = AnfitrionArrayListsFK.getSexoFK(fkSexo);
        int idTipoId = AnfitrionArrayListsFK.getIdentificacionTipoFK(fkTipoID);
        int idNacionalidad = AnfitrionArrayListsFK.getNacionalidadFK(fkNacionalidad);
        /* Validar que los datos ingresados sean los solicitados */
        p = new Anfitrion(identificador, nombres, apellidos, dtcFechaNac.getDate(), email, "HABILITADO", idTipoId, idSexo, idNacionalidad);
        if (Validaciones.vAnfitrion(p)) {
            p = Conversiones.anfitrionUpperCase(p);
            return true;
        }
        return false;
    }

    /* Insertar registro a la Base de datos */
    public static void insertarRegistro() {
        AdmAnfitrionesDAO.insertar(p);
    }

    /* Actualizar registro a la Base de datos */
    public static void actualizarRegistro(String identificadorPersona) {
        AdmAnfitrionesDAO.actualizar(identificadorPersona, p);
    }

    /* Eliminar registro a la Base de datos */
    public static void eliminarRegistro(String identificadorPersona, int indice) {
        AdmAnfitrionesDAO.eliminar(identificadorPersona);
    }

    /* Limpiar los campos del formulario */
    public static void limpiarCampos(JTextField txtCedula, JTextField txtNombres, JTextField txtApellidos, JTextField txtEmail, JDateChooser dtcFechaNac) {
        txtCedula.setText(" ");
        txtNombres.setText(" ");
        txtApellidos.setText(" ");
        dtcFechaNac.setDate(new Date(2000 - 1900, 0, 1));
    }

    /* Metodo para actualizar los registros de la tabla del formulario */
    public static void actualizarTabla(JTable tblPersonas) {
        tamanoColumnasTabla(tblPersonas);
        ArrayList<Anfitrion> lista = AdmAnfitrionesDAO.consultar();
        DefaultTableModel model = (DefaultTableModel) tblPersonas.getModel();
        model.setRowCount(0);
        /* Insertar registros a la tabla del formulario */
        for (Anfitrion x : lista) {
            Object[] rowData = new Object[5];
            rowData[0] = x.getIdentificador();
            rowData[1] = x.getNombres();
            rowData[2] = x.getApellidos();
            rowData[3] = AnfitrionArrayListsFK.getIdentificacionTipo(x.getTipoId());
            rowData[4] = AnfitrionArrayListsFK.getSexo(x.getSexo());
            model.addRow(rowData);
        }
    }

    /* Modificar el ancho de las columnas de la tabla */
    public static void tamanoColumnasTabla(JTable tblPersonas) {
        int[] anchos = {6, 70, 70, 150, 10};
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
        Anfitrion x = buscarCedula(identificador);
        txtCedula.setText(x.getIdentificador());
        txtNombres.setText(x.getNombres());
        txtApellidos.setText(x.getApellidos());
        txtEmail.setText(x.getEmail());
        cmbNacionalidad.setSelectedIndex(x.getNacionalidad() - 1);
        cmbSexo.setSelectedIndex(x.getSexo() - 1);
        cmbTipoId.setSelectedIndex(x.getTipoId() - 1);
        dtcFechaNac.setDate(Conversiones.getDate(x.getFechaNac().toString()));
    }

    /* Buscar una cedula que se encuentre registrada */
    public static Anfitrion buscarCedula(String identificador) {
        ArrayList<Anfitrion> listaPersonas = AdmAnfitrionesDAO.consultar();
        for (Anfitrion x : listaPersonas) {
            if (x.getIdentificador().compareToIgnoreCase(identificador) == 0) {
                return x;
            }
        }
        return null;
    }

}
