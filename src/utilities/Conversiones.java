/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import model.Persona;

/**
 *
 * @author N1L0XD
 */
public class Conversiones {
    
    public static Persona personaUpperCase(Persona persona){
        return new Persona(persona.getIdentificador(), persona.getNombres().toUpperCase(), persona.getApellidos().toUpperCase(), persona.getFechaNac(), persona.getEmail().toUpperCase(), persona.getEstado().toUpperCase(), persona.getTipoId(), persona.getSexo(), persona.getNacionalidad());
    }

    public static String getFecha(JDateChooser jd) {
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }

    public static String getFecha(java.util.Date fecha) {
        SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (fecha != null) {
            return Formato.format(fecha);
        } else {
            return null;
        }
    }

    public static java.sql.Timestamp getFecha(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date parsedDate = sdf.parse(fecha);
            return new java.sql.Timestamp(parsedDate.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    public static long getEdad(java.util.Date fecha) {
        LocalDate start = LocalDate.of(fecha.getYear()+1900, fecha.getMonth() , fecha.getDay());
        LocalDate stop = LocalDate.now(ZoneId.of("America/Montreal"));
        long years = java.time.temporal.ChronoUnit.YEARS.between(start, stop);
        return years;
    }
}
