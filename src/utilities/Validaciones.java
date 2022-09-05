/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import controller.AdmAnfitriones;
import controller.AdmHabitaciones;
import controller.AdmHuespedes;
import controller.AdmViviendas;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Anfitrion;
import model.Habitacion;
import model.Huesped;
import model.Pago;
import model.Promocion;
import model.Vivienda;

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

    public static boolean vDouble(String cadena) {
        try {
            double num = Double.parseDouble(cadena);
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
        } else {
            System.out.println("Error: la cadena esta vacia.");
            return false;
        }
        return true;
    }

    /*Validar que la persona sea mayor de edad*/
    public static boolean vEdad(long edad) {
        if (edad >= 18) {
            System.out.println("Mayor de edad admitido.");
            return true;
        } else {
            System.out.println("Menor de edad no admitido.");
            return false;
        }
        //return (edad >= 18) ? true : false;
    }

    //Establecer el numero de habitaciones permitidas por vivienda
    public static boolean vNumHab(int num) {
        if (num >= 10 && num <= 100) {
            return true;
        } else {
            System.out.println("Numero mayor a 100 habitaciones no permitido.");
            System.out.println("Se requieren 10 habitaciones Minimo.");
            return false;
        }
        //return (num >= 100) ? false : true;
    }

    //Establecer el precio máximo por habitacion.
    public static boolean vPrecioHab(double num) {
        if (num >= 10000) {
            System.out.println("Precio mayor a 10000 dólares no permitido.");
            return false;
        } else {
            return true;
        }
        //return (num >= 10000) ?  false : true;
    }

    //Establecer 5 Personas como maximo por habitaciones.
    public static boolean vMaxPerHab(double num) {
        if (num >= 5) {
            System.out.println("Cantidad de 5 personas por habitaciones no permitido.");
            return false;
        } else {
            return true;
        }
        //return (num >= 10000) ?  false : true;
    }

    public static boolean existeAnfitrion(String cedula) {
        Anfitrion o = AdmAnfitriones.buscarCedula(cedula);
        if (o != null) {
            JOptionPane.showMessageDialog(null, "La cedula ingresada ya existe: " + cedula);
            return false;
        } else {
            return true;
        }
    }

    public static boolean existeHuesped(String cedula) {
        Huesped o = AdmHuespedes.buscarCedula(cedula);
        if (o != null) {
            JOptionPane.showMessageDialog(null, "La cedula ingresada ya existe: " + cedula);
            return false;
        } else {
            return true;
        }
    }

    //Validar que los datos ingresado de la entidad Persona sean correctos
    public static boolean vAnfitrion(Anfitrion persona) {
        boolean nombres = vWords(persona.getNombres());
        boolean apellidos = vWords(persona.getApellidos());
        boolean tipoId = vInt(persona.getTipoId());
        boolean sexoId = vInt(persona.getSexo());
        boolean mayorEdad = vEdad(Conversiones.getEdad(persona.getFechaNac()));
        return nombres && apellidos && tipoId && sexoId && mayorEdad;
    }

    //Validar que los datos ingresado de la entidad Persona sean correctos
    public static boolean vHuesped(Huesped persona) {
        boolean nombres = vWords(persona.getNombres());
        boolean apellidos = vWords(persona.getApellidos());
        boolean tipoId = vInt(persona.getTipoId());
        boolean sexoId = vInt(persona.getSexo());
        boolean mayorEdad = vEdad(Conversiones.getEdad(persona.getFechaNac()));
        return nombres && apellidos && tipoId && sexoId && mayorEdad;
    }

    //Validar que los datos ingresado de la entidad Vivienda sean correctos
    public static boolean vVivienda(Vivienda vivienda) {
        boolean nombres = vWords(vivienda.getNombre());
        boolean anfitrion = vInt(vivienda.getAnfitrion());
        boolean tipoVivienda = vInt(vivienda.getTipoVivienda());
        boolean estadoVivienda = vInt(vivienda.getEstadoVivienda());
        boolean ciudad = vInt(vivienda.getCiudad());
        return nombres && anfitrion && tipoVivienda && estadoVivienda && ciudad;
    }

    //Validar que los datos ingresado de la entidad Habitacion sean correctos
    public static boolean vHabitacion(Habitacion habitacion) {
        boolean precio = vPrecioHab(habitacion.getPrecio());
        boolean numPer = vMaxPerHab(habitacion.getNumMax());
        return precio && numPer;
    }

    public static boolean existeVivienda(String identificador) {
        Vivienda o = AdmViviendas.buscarVivienda(identificador);
        if (o != null) {
            JOptionPane.showMessageDialog(null, "Vivienda ingresada ya existe: " + identificador);
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarFecha(Date fecha) {
        return !fecha.before(new Date(System.currentTimeMillis()));
    }

    public static boolean validarFecha(Date fechaI, Date fechaF) {
        return fechaI.before(fechaF);
    }

    public static boolean vPromocion(Promocion p) {
        boolean fechaI = validarFecha(p.getFechaInicio());
        boolean fechaF = validarFecha(p.getFechaInicio(), p.getFechaFinal());
        return fechaI && fechaF;
    }

    public static boolean existeHabitacion(String identificadorVivienda, String identificadorHabitacion) {
        Habitacion o = AdmHabitaciones.buscarHabitacion(identificadorVivienda, identificadorHabitacion);
        if (o != null) {
            JOptionPane.showMessageDialog(null, "Habitacion ingresada ya existe: " + identificadorHabitacion + " en la vivienda: " + identificadorVivienda);
            return false;
        } else {
            return true;
        }
    }

    public static boolean vPago(Pago p) {
        boolean huesped = vInt(p.getHuesped());
        boolean fechaI = validarFecha(p.getFechaInicio());
        boolean fechaF = validarFecha(p.getFechaInicio(), p.getFechaFinal());
        boolean precio = vPrecioHab(p.getMonto());
        return huesped && fechaI && fechaF && precio;
    }

    public static boolean vPagoFechas(Pago p) {
        return p.getFechaInicio()!=null && p.getFechaFinal()!=null ;
    }
}
