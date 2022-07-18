/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestUtilities;

import java.util.Date;
import model.Persona;
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
        
        //Comprobar datos de objeto Persona -> ESCENARIO EDAD MENOR DE EDAD
        System.out.println("Comprobar datos de objeto Persona -> ESCENARIO EDAD MENOR DE EDAD");
        System.out.println(new Persona("0931600548", "IVONNE ", "MINCHALA ", new Date(), "IVONNE@GMAIL.COM", "HABILITADO", 0, 0, 0).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "IVONNE ", "MINCHALA ", new Date(), "IVONNE@GMAIL.COM", "HABILITADO", 0, 0, 0)));        
        
        //Comprobar datos de objeto Persona -> ESCENARIO EDAD MAYOR DE EDAD
        System.out.println("Comprobar datos de objeto Persona -> ESCENARIO EDAD MAYOR DE EDAD");
        System.out.println(new Persona("0931600548", "DANILO ", "PIN ", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "DANILO ", "PIN ", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0)));
        
        //Comprobar datos de objeto Persona -> ESCENARIO NOMBRES O APELLIDOS CONTIENEN NUMEROS
        System.out.println("Comprobar datos de objeto Persona -> ESCENARIO NOMBRES O APELLIDOS CONTIENEN NUMEROS");
        System.out.println(new Persona("0931600548", "DANILO123 12313", "PIN ", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "DANILO123 12313", "PIN ", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0)));
        
        System.out.println(new Persona("0931600548", "DANILO ", "11111 1111231", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "DANILO ", "11111 1111231", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0)));
        
        System.out.println(new Persona("0931600548", "", "11111 1111231", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "", "11111 1111231", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0)));
        
        //Comprobar datos de objeto Persona -> ESCENARIO LLAVES DE OBJETO CONTIENEN LETRAS O CARACTERES NO ADMITIDOS
        System.out.println("Comprobar datos de objeto Persona -> ESCENARIO LLAVES DE OBJETO CONTIENEN LETRAS O CARACTERES NO ADMITIDOS ");
        System.out.println(new Persona("0931600548", "KENETH ", "RIERA", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "KENETH@GMAIL.COM", "HABILITADO", 1, 0, 1).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "KENETH ", "RIERA", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "KENETH@GMAIL.COM", "HABILITADO", 1, 0, 1)));
    }
}
