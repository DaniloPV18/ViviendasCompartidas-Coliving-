/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import arraylists.ArrayListsFK;
import com.toedter.calendar.JDateChooser;
import controllerDB.AdmPersonasDataBase;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Persona;
import utilities.Conversiones;
import utilities.Validaciones;

/**
 *
 * @author N1L0XD
 */
public class AdmPersonas {
    
    private static Persona p = null;

    public static boolean validarDatos(String identificador, String nombres, String apellidos, String email, String fkSexo, String fkTipoID, String fkNacionalidad, JDateChooser dtcFechaNac) {      
        /* Obtener las llaves foráneas de los combobox a través de los ArrayList */
        int idSexo = ArrayListsFK.getSexoFK(fkSexo);
        int idTipoId = ArrayListsFK.getTipoIdentificacionFK(fkTipoID);
        int idNacionalidad = ArrayListsFK.getNacionalidadFK(fkNacionalidad);
        /* Validar que los datos ingresados sean los solicitados */
        p = new Persona(identificador, nombres, apellidos, dtcFechaNac.getDate(), email, "HABILITADO", idTipoId, idSexo, idNacionalidad);
        if(Validaciones.vPersona(p)){            
            p = Conversiones.personaUpperCase(p);
            return true;
        }                
        return false;
    }

    /* Insertar registro a la Base de datos */
    public static void insertarRegistro() {
        AdmPersonasDataBase.insertar(p);
    }

    /* Limpiar los campos del formulario */
    public static void limpiarCampos(JTextField txtCedula, JTextField txtNombres, JTextField txtApellidos, JTextField txtEmail, JDateChooser dtcFechaNac) {
        txtCedula.setText(" ");
        txtNombres.setText(" ");
        txtApellidos.setText(" ");
        dtcFechaNac.setDate(new Date(2000-1900, 0, 1));
    }

    /* Metodo para actualizar los registros de la tabla del formulario */
    public static void actualizarTabla(JTable tblPersonas) {
        tamanoColumnasTabla(tblPersonas);
        ArrayList<Persona> lista = AdmPersonasDataBase.consultar();
        DefaultTableModel model = (DefaultTableModel) tblPersonas.getModel();        
        model.setRowCount(0);    
        /* Insertar registros a la tabla del formulario */
        for (Persona x : lista) {
            Object[] rowData = new Object[5];
            rowData[0] = x.getIdentificador();
            rowData[1] = x.getNombres();
            rowData[2] = x.getApellidos();
            rowData[3] = ArrayListsFK.getTipoIdentificacion(x.getTipoId());
            rowData[4] = ArrayListsFK.getSexo(x.getSexo());
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
    
}
