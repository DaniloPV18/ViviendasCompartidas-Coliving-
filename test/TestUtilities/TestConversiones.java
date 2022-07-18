/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestUtilities;

import utilities.Conversiones;

/**
 *
 * @author N1L0XD
 */
public class TestConversiones {
    public static void main(String[] args) {
        //Conversion de Date Java to String
        System.out.println(Conversiones.getFecha(new java.util.Date()));
        //Conversion de Date Java to String y de String to SQL Date
        System.out.println(Conversiones.getFecha(Conversiones.getFecha(new java.util.Date())));
        //Obtener edad a partir del Date Java
        System.out.println(Conversiones.getEdad(new java.util.Date()));
        //Obtener edad a partir del Calendario Java
        java.util.Date date = new java.util.GregorianCalendar(2014, java.util.Calendar.FEBRUARY, 11).getTime();
        System.out.println(Conversiones.getEdad(date));
        
    }
}
