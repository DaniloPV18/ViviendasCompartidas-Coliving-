/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUtilities;

import java.util.Date;
import model.Anfitrion;
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
        //Conversion UpperPersona
        Anfitrion p = Conversiones.anfitrionUpperCase(new Anfitrion("00000001", "melant sedasd", "weeee PRUEBA", new Date(), "test@GMAIL.COM", "habilitado", 1, 1, 1));
        System.out.println(p.toString());
        
    }
}
