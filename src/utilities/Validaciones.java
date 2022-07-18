/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author N1L0XD
 */
public class Validaciones {

    
    public static boolean vInt(String cadena) {
        try {
            int num = Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: la cadena debe contener solo números.");
            return false;
        }
    }

    public static boolean vWords(String cadena) {
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            // Si no está entre a y z, ni entre A y Z, ni es un espacio
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                System.out.println("Error: la cadena tiene numeros.");
                return false;
            }
        }
        return true;
    }

    public static boolean vEdad(long edad) {
        return (edad >= 18)? true: false;
    }
}
