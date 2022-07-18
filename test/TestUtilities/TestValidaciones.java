/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestUtilities;

import utilities.Validaciones;
/**
 *
 * @author N1L0XD
 */
public class TestValidaciones {
    public static void main(String[] args) {
        // Comprobar si es numero
        System.out.println(Validaciones.vInt("s"));
        System.out.println(Validaciones.vInt("100"));
        // Comprobar si es una palabra
        System.out.println(Validaciones.vWords("Danilo"));
        System.out.println(Validaciones.vWords("Danilo12913"));
        // Comprobar si es mayor de edad
        System.out.println(Validaciones.vEdad(19));
        System.out.println(Validaciones.vEdad(15));
    }
}
