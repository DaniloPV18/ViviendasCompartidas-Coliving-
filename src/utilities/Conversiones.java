/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;

/**
 *
 * @author N1L0XD
 */
public class Conversiones {

    public static String getFecha(JDateChooser jd) {
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }
    
    public static String getFecha(java.util.Date fecha){
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
        if (fecha != null) {
            return Formato.format(fecha);
        } else {
            return null;
        }
    }
    
    public static java.sql.Date getFecha(String fecha){
       java.sql.Date dateSql= java.sql.Date.valueOf(fecha);
       return dateSql;
    }
       

}
