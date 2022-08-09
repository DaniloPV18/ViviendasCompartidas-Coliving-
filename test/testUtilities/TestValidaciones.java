/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUtilities;

import java.util.Date;
import model.Habitacion;
import model.Persona;
import model.Vivienda;
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
        
        testPersonas();
        testViviendas();
        testHabitaciones();
    }

    private static void testPersonas() {
        
        //Comprobar datos de objeto Persona -> ESCENARIO EDAD MENOR DE EDAD
        System.out.println("Comprobar datos de objeto Persona -> ESCENARIO EDAD MENOR DE EDAD");
        System.out.println(new Persona("0931600548", "IVONNE ", "MINCHALA ", new Date(), "IVONNE@GMAIL.COM", "HABILITADO", 0, 0, 0).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "IVONNE ", "MINCHALA ", new Date(), "IVONNE@GMAIL.COM", "HABILITADO", 0, 0, 0)));        
        
        //Comprobar datos de objeto Persona -> ESCENARIO EDAD MAYOR DE EDAD
        System.out.println("Comprobar datos de objeto Persona -> ESCENARIO EDAD MAYOR DE EDAD");
        System.out.println(new Persona("0931600548", "DANILO ", "PIN ", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "DANILO ", "PIN ", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0)));
        
        //Comprobar datos de objeto Persona -> ESCENARIO NOMBRES CONTIENEN NUMEROS
        System.out.println("Comprobar datos de objeto Persona -> ESCENARIO NOMBRES CONTIENEN NUMEROS");
        System.out.println(new Persona("0931600548", "DANILO123 12313", "PIN ", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "DANILO123 12313", "PIN ", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0)));
        
        //Comprobar datos de objeto Persona -> ESCENARIO APELLIDOS CONTIENEN NUMEROS
        System.out.println("Comprobar datos de objeto Persona -> ESCENARIO APELLIDOS CONTIENEN NUMEROS");
        System.out.println(new Persona("0931600548", "DANILO ", "11111 1111231", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "DANILO ", "11111 1111231", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0)));
        
        //Comprobar datos de objeto Persona -> ESCENARIO NOMBRES O APELLIDOS SE ENCUENTRAN VACIOS
        System.out.println("Comprobar datos de objeto Persona -> ESCENARIO NOMBRES O APELLIDOS SE ENCUENTRAN VACIOS");
        System.out.println(new Persona("0931600548", "", "11111 1111231", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "", "11111 1111231", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "DANILO@GMAIL.COM", "HABILITADO", 0, 0, 0)));
        
        //Comprobar datos de objeto Persona -> ESCENARIO CARACTERES NO ADMITIDOS EN EL CAMPO NOMBRES O APELLIDOS
        System.out.println("Comprobar datos de objeto Persona -> ESCENARIO CARACTERES NO ADMITIDOS EN EL CAMPO NOMBRES O APELLIDOS ");
        System.out.println(new Persona("0931600548", "KENETH{", "}RIERA", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "KENETH@GMAIL.COM", "HABILITADO", 1, 0, 1).toString());
        System.out.println(Validaciones.vPersona(new Persona("0931600548", "KENETH{", "}RIERA", new java.util.GregorianCalendar(2000, java.util.Calendar.FEBRUARY, 11).getTime(), "KENETH@GMAIL.COM", "HABILITADO", 1, 0, 1)));
    }

    private static void testViviendas() {
        //Comprobar datos de objeto Vivienda -> ESCENARIO NOMBRES DE PROPIEDAD NO CONTIENEN NUMEROS
        System.out.println("Comprobar datos de objeto Vivienda -> ESCENARIO NOMBRES DE PROPIEDAD NO CONTIENEN NUMEROS");
        System.out.println(new Vivienda
        ("000000003", "COLIVING TURISTICO",  "COLIVINGTURISTICO@GMAIL.COM", "SUR GUAYAQUIL", 10, 1, 1, 3, 1).toString());
        System.out.println(Validaciones.vVivienda(new Vivienda
        ("000000003", "COLIVING TURISTICO", "COLIVINGTURISTICO@GMAIL.COM", "SUR GUAYAQUIL", 10, 1, 1, 3, 1) ));
        
        //Comprobar datos de objeto Vivienda -> ESCENARIO NOMBRES DE PROPIEDAD CONTIENEN NUMEROS
        System.out.println("Comprobar datos de objeto Vivienda -> ESCENARIO NOMBRES DE PROPIEDAD CONTIENEN NUMEROS");
        System.out.println(new Vivienda
        ("000000003", "12312321 TURISTICO", "COLIVINGTURISTICO@GMAIL.COM", "SUR GUAYAQUIL", 10, 1, 1, 3, 1).toString());
        System.out.println(Validaciones.vVivienda(new Vivienda
        ("000000003", "12312321 TURISTICO", "COLIVINGTURISTICO@GMAIL.COM", "SUR GUAYAQUIL", 10, 1, 1, 3, 1)));
        
        //Comprobar datos de objeto Vivienda -> ESCENARIO NUMERO DE HABITACIONES DE UNA PROPIEDAD MAYOR O IGUAL A 100
        System.out.println("Comprobar datos de objeto Vivienda -> ESCENARIO NUMERO DE HABITACIONES DE UNA PROPIEDAD MAYOR O IGUAL A 100");
        System.out.println(new Vivienda
        ("000000003", "CENTRO TURISTICO", "COLIVINGTURISTICO@GMAIL.COM", "SUR GUAYAQUIL", 100, 1, 1, 3, 1).toString());
        System.out.println(Validaciones.vVivienda(new Vivienda
        ("000000003", "CENTRO TURISTICO", "COLIVINGTURISTICO@GMAIL.COM", "SUR GUAYAQUIL", 100, 1, 1, 3, 1)));
        
        //Comprobar datos de objeto Vivienda -> ESCENARIO NUMERO DE HABITACIONES DE UNA PROPIEDAD MENOR QUE 100
        System.out.println("Comprobar datos de objeto Vivienda -> ESCENARIO NUMERO DE HABITACIONES DE UNA PROPIEDAD MAYOR O IGUAL A 10");
        System.out.println(new Vivienda
        ("000000003", "CENTRO TURISTICO", "COLIVINGTURISTICO@GMAIL.COM", "SUR GUAYAQUIL", 9, 1, 1, 3, 1).toString());
        System.out.println(Validaciones.vVivienda(new Vivienda
        ("000000003", "CENTRO TURISTICO", "COLIVINGTURISTICO@GMAIL.COM", "SUR GUAYAQUIL", 9, 1, 1, 3, 1)) );
    }

    private static void testHabitaciones() {
        //Comprobar datos de objeto Habitacion -> ESCENARIO HABITACION CON PRECIO MENOR QUE 10000
        System.out.println("Comprobar datos de objeto Habitacion -> ESCENARIO PRECIO MENOR QUE 10000");
        System.out.println(new Habitacion(101, 4, true, 100 , 1, 1, 1, 0).toString());
        System.out.println(Validaciones.vHabitacion(new Habitacion(101, 4, true, 100 , 1, 1, 1, 0)));
        
        //Comprobar datos de objeto Habitacion -> ESCENARIO HABITACION CON PRECIO MAYOR O IGUAL A 10000
        System.out.println("Comprobar datos de objeto Habitacion -> ESCENARIO PRECIO MAYOR O IGUAL A 10000");
        System.out.println(new Habitacion(101, 4, true, 10000 , 1, 1, 1, 0).toString());
        System.out.println(Validaciones.vHabitacion(new Habitacion(101, 4, true, 10000 , 1, 1, 1, 0)));
    }
}
