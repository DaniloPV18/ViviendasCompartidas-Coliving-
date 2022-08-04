/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import arraylists.ArrayListsFK;
import com.toedter.calendar.JDateChooser;
import model.Persona;
import utilities.Validaciones;

/**
 *
 * @author N1L0XD
 */
public class AdmPersonas {

    public static boolean validarDatos(String identificador, String nombres, String apellidos, String email, String fkSexo, String fkTipoID, String fkNacionalidad, JDateChooser dtcFechaNac) {      
        
        int idSexo = ArrayListsFK.getSexoFK(fkSexo);
        int idTipoId = ArrayListsFK.getTipoIdentificacionFK(fkTipoID);
        int idNacionalidad = ArrayListsFK.getNacionalidadFK(fkNacionalidad);
        
        System.out.println(dtcFechaNac.getDate());
        
        if(Validaciones.vInt(idSexo) && Validaciones.vInt(idTipoId) && Validaciones.vInt(idNacionalidad)){
            Persona p = new Persona(
                    identificador, 
                    nombres, 
                    apellidos, 
                    dtcFechaNac.getDate(), 
                    email, 
                    "HABILITADO", 
                    idSexo, 
                    idTipoId, 
                    idNacionalidad
            );
            if(Validaciones.vPersona(p)){
                System.out.println(p.toString());
                return true;
            }
        }        
        return false;
    }
    
}
