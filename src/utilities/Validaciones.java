/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import model.Habitacion;
import model.Persona;
import model.Propiedad;

/**
 *
 * @author N1L0XD
 */
public class Validaciones {
    
    /*Validar que la cadena ingresada sean solo números desde una Cadena*/
    public static boolean vInt(String cadena) {
        try {
            int num = Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: la cadena debe contener solo números.");
            return false;
        }
    }

    /*Validar que la cadena ingresada sean solo números desde Enteros*/
    public static boolean vInt(int numero) {
        try {
            int num = numero;
            return true;
        } catch (Exception e) {
            System.out.println("Error: la cadena debe contener solo números.");
            return false;
        }
    }

    /*Validar que la cadena sean solos letras o espacios*/
    public static boolean vWords(String cadena) {
        if (!cadena.isBlank() && !cadena.isEmpty()) {
            for (int x = 0; x < cadena.length(); x++) {
                char c = cadena.charAt(x);
                // Si no está entre a y z, ni entre A y Z, ni es un espacio
                if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                    System.out.println("Error: la cadena tiene numeros.");
                    return false;
                }
            }
        }else{
            System.out.println("Error: la cadena esta vacia.");
            return false;
        }
        return true;
    }

    /*Validar que la persona sea mayor de edad*/
    public static boolean vEdad(long edad) {
        if(edad >=18){
            System.out.println("Mayor de edad admitido.");
            return true;
        }else{
            System.out.println("Menor de edad no admitido.");
            return false;
        }
        //return (edad >= 18) ? true : false;
    }

    //Establecer el numero de habitaciones permitidas por propiedad
    public static boolean vNumHab(int num) {
        if(num>= 10 && num<=100){
            return true;
        }else{
            System.out.println("Numero mayor a 100 habitaciones no permitido.");
            System.out.println("Se requieren 10 habitaciones Minimo.");
            return false;
        }       
        //return (num >= 100) ? false : true;
    }
    
    //Establecer el precio máximo por habitacion.
    public static boolean vPrecioHab(double num) {
        if(num >= 10000){
            System.out.println("Precio mayor a 10000 dólares no permitido.");
            return false;
        }else{
            return true;
        }
        //return (num >= 10000) ?  false : true;
    }
    
    //Establecer 5 Personas como maximo por habitaciones.
    public static boolean vMaxPerHab(double num) {
        if(num >= 5){
            System.out.println("Cantidad de 5 personas por habitaciones no permitido.");
            return false;
        }else{
            return true;
        }
        //return (num >= 10000) ?  false : true;
    }
    
    //Validar que los datos ingresado de la entidad Persona sean correctos
    public static boolean vPersona(Persona persona) {
        boolean nombres = vWords(persona.getNombres());
        boolean apellidos = vWords(persona.getApellidos());
        boolean tipoId = vInt(persona.getTipoId());
        boolean sexoId = vInt(persona.getSexo());
        boolean mayorEdad = vEdad(Conversiones.getEdad(persona.getFechaNac()));
        return nombres && apellidos && tipoId && sexoId && mayorEdad;
    }
    
    //Validar que los datos ingresado de la entidad Propiedad sean correctos
    public static boolean vPropiedad(Propiedad propiedad) {
        boolean nombres = vWords(propiedad.getNombre());
        boolean numHab = vNumHab(propiedad.getNumHab());
        boolean anfitrion = vInt(propiedad.getAnfitrion());
        boolean tipoPropiedad = vInt(propiedad.getTipoPropiedad());
        boolean estadoPropiedad = vInt(propiedad.getEstadoPropiedad());
        boolean ciudad = vInt(propiedad.getCiudad());
        return nombres && numHab && anfitrion && tipoPropiedad && estadoPropiedad && ciudad;
    }

    //Validar que los datos ingresado de la entidad Habitacion sean correctos
    public static boolean vHabitacion(Habitacion habitacion) {
        boolean precio = vPrecioHab(habitacion.getPrecio());
        boolean numPer = vMaxPerHab(habitacion.getNumMax());
        return precio && numPer;
    }
}
