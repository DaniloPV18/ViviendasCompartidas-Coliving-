/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import model.Persona;
import model.Vivienda;

/**
 *
 * @author N1L0XD
 */
public class Conversiones {
    
    /* Convertir los textos ingresados en los datos del objeto Persona en Mayusculas */
    public static Persona personaUpperCase(Persona persona){
        return new Persona(persona.getIdentificador(), persona.getNombres().toUpperCase(), persona.getApellidos().toUpperCase(), persona.getFechaNac(), persona.getEmail().toUpperCase(), persona.getEstado().toUpperCase(), persona.getTipoId(), persona.getSexo(), persona.getNacionalidad());
    }

    /* Convertir los textos ingresados en los datos del objeto Vivienda en Mayusculas */
    public static Vivienda viviendaUpperCase(Vivienda vivienda){
        return new Vivienda(vivienda.getIdentificador(), vivienda.getNombre().toUpperCase(), vivienda.getEmail().toUpperCase(), vivienda.getDireccion().toUpperCase(),vivienda.getNumHab(),vivienda.getAnfitrion(),vivienda.getTipoVivienda(),vivienda.getEstadoVivienda(),vivienda.getCiudad());
    }
    
    /* Convertir la fecha de JDatechooser en String*/
    public static String getFecha(JDateChooser jd) {
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    /* Convertir la fecha de Date(Java) en String*/
    public static String getFecha(java.util.Date fecha) {
        SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (fecha != null) {
            return Formato.format(fecha);
        } else {
            return null;
        }
    }
    
    /* Convertir String a Date(Java) */
    public static java.util.Date getDate(String fecha){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = formatter.parse(fecha);
            return date;
        } catch (ParseException ex) {
            return null;
        }
    }

    /* Convertir String en TimeStamp SQL*/
    public static java.sql.Timestamp getFecha(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date parsedDate = sdf.parse(fecha);
            return new java.sql.Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /* Metodo para obtener la edad a través de un Date(Java) */
    public static long getEdad(java.util.Date fecha) {
        LocalDate start = LocalDate.of(fecha.getYear()+1900, fecha.getMonth()+1 , fecha.getDay());
        LocalDate stop = LocalDate.now(ZoneId.of("America/Montreal"));
        long years = java.time.temporal.ChronoUnit.YEARS.between(start, stop);
        return years;
    }
}
