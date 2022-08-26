/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylists;

import components.JSwingUtilsPersona;
import java.util.ArrayList;
import model.Nacionalidad;
import model.Sexo;
import model.IdentificacionTipo;

/**
 *
 * @author N1L0XD
 */
public class AnfitrionArrayListsFK {
    
    /* Metodo para recuperar la llave foránea(ID) a partir de la cadena ingresada */
    public static int getSexoFK(String nombre){
        ArrayList<Sexo> lista = JSwingUtilsPersona.getInstance().getListaSexoBD();
        for (Sexo x : lista) {
            if(nombre.compareToIgnoreCase(x.getNombre()) == 0){
                return x.getId();
            }
        }
        return 0;
    }
    
    /* Metodo para recuperar la cadena partir de la llave foránea(ID) ingresada */
    public static String getSexo(int id){
        ArrayList<Sexo> lista = JSwingUtilsPersona.getInstance().getListaSexoBD();
        for (Sexo x : lista) {
            if(id == x.getId()){
                return x.getNombre();
            }
        }
        return "-";
    }
    
    /* Metodo para recuperar la llave foránea(ID) a partir de la cadena ingresada */
    public static int getIdentificacionTipoFK(String nombre){
        ArrayList<IdentificacionTipo> lista = JSwingUtilsPersona.getInstance().getListaTipoIdBD();
        for (IdentificacionTipo x : lista) {
            if(nombre.compareToIgnoreCase(x.getNombre()) == 0){
                return x.getId();
            }
        }
        return 0;
    } 
    
    /* Metodo para recuperar la cadena partir de la llave foránea(ID) ingresada */
    public static String getIdentificacionTipo(int id){
        ArrayList<IdentificacionTipo> lista = JSwingUtilsPersona.getInstance().getListaTipoIdBD();
        for (IdentificacionTipo x : lista) {
            if(id == x.getId()){
                return x.getNombre();
            }
        }
        return "-";
    }
    
    /* Metodo para recuperar la llave foránea(ID) a partir de la cadena ingresada */
    public static int getNacionalidadFK(String nombre){
        ArrayList<Nacionalidad> lista = JSwingUtilsPersona.getInstance().getListaNacionalidadBD();
        for (Nacionalidad x : lista) {
            if(nombre.compareToIgnoreCase(x.getNombre()) == 0){
                return x.getId();
            }
        }
        return 0;
    }    
}
