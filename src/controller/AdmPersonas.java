/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import arraylists.ArrayListsFK;
import com.toedter.calendar.JDateChooser;
import controllerDB.AdmPersonasDataBase;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
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
        p = new Persona(identificador, nombres, apellidos, dtcFechaNac.getDate(), email, "HABILITADO", idSexo, idTipoId, idNacionalidad);
        if(Validaciones.vPersona(p)){            
            p = Conversiones.personaUpperCase(p);
            return true;
        }                
        return false;
    }

    public static void insertarRegistro() {
        AdmPersonasDataBase.insertar(p);
    }

    public static void limpiarCampos(JTextField txtCedula, JTextField txtNombres, JTextField txtApellidos, JTextField txtEmail, JDateChooser dtcFechaNac) {
        txtCedula.setText(" ");
        txtNombres.setText(" ");
        txtApellidos.setText(" ");
        dtcFechaNac.setDate(new Date(2000-1900, 0, 1));
    }
    
}
