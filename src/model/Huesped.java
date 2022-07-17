/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author N1L0XD
 */
public class Huesped extends Persona {
    public Huesped(String identificador, String nombres, String apellidos, Date fechaNac, String email, String estado, TipoIdentificacion tipoId, Sexo sexo, Nacionalidad nacionalidad){
        super(identificador, nombres, apellidos, fechaNac, email, estado, tipoId, sexo, nacionalidad);
    }  
}
