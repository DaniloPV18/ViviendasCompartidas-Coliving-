/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import arraylists.ArrayListsFK;
import com.toedter.calendar.JDateChooser;
import controllerDB.AdmPersonasDataBase;
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
        
        int idSexo = ArrayListsFK.getSexoFK(fkSexo);
        int idTipoId = ArrayListsFK.getTipoIdentificacionFK(fkTipoID);
        int idNacionalidad = ArrayListsFK.getNacionalidadFK(fkNacionalidad);
        
        if(Validaciones.vInt(idSexo) && Validaciones.vInt(idTipoId) && Validaciones.vInt(idNacionalidad)){
            p = new Persona(identificador, nombres, apellidos, dtcFechaNac.getDate(), email, "HABILITADO", idSexo, idTipoId, idNacionalidad);
            if(Validaciones.vPersona(p)){                
                p = Conversiones.personaUpperCase(p);
                return true;
            }
        }        
        return false;
    }

    public static void insertarRegistro() {
        if(p != null){            
            System.out.println(p.toString());
            //AdmPersonasDataBase.insertar(p);
        }
    }
    
}
