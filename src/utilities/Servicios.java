/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import model.Persona;

/**
 *
 * @author N1L0XD
 */
public class Servicios {
    
    public static Persona setPersona(Persona persona){
        return new Persona(persona.getIdentificador(), persona.getNombres().toUpperCase(), persona.getApellidos().toUpperCase(), persona.getFechaNac(), persona.getEmail().toUpperCase(), persona.getEstado().toUpperCase(), persona.getTipoId(), persona.getSexo(), persona.getNacionalidad());
    }
    
}
