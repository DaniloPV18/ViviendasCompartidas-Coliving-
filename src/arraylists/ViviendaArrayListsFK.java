/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylists;

import components.JSwingUtilsVivienda;
import controllerDAO.AdmViviendasDAO;
import java.util.ArrayList;
import model.Anfitrion;
import model.Ciudad;
import model.Vivienda;
import model.ViviendaTipo;

/**
 *
 * @author N1L0XD
 */
public class ViviendaArrayListsFK {    
      
    public static int getViviendaPK(String idVivienda) {
        ArrayList<Vivienda> lista = AdmViviendasDAO.consultar();
        for (Vivienda x : lista) {
            if(idVivienda.compareToIgnoreCase(x.getIdentificador()) == 0){
                return x.getId();
            }
        }
        return 0;
    }
    
    public static String getViviendaIdentificador(String nombreVivienda){
        ArrayList<Vivienda> lista = AdmViviendasDAO.consultar();
        for (Vivienda x : lista) {
            if(nombreVivienda.compareToIgnoreCase(x.getNombre()) == 0){
                return x.getIdentificador();
            }
        }
        return "-";
    }
    
    /* Metodo para recuperar la llave foránea(ID) a partir de la cadena ingresada */
    public static int getAnfitrionFK(String anfitrion) {
        ArrayList<Anfitrion> lista = JSwingUtilsVivienda.getInstance().getListaAnfitrionBD();
        for (Anfitrion x : lista) {
            if(anfitrion.compareToIgnoreCase(x.getIdentificador()) == 0){
                return x.getId();
            }
        }
        return 0;
    }
    
    /* Metodo para recuperar la cadena partir de la llave foránea(ID) ingresada */
    public static String getAnfitrion(int anfitrion){
        ArrayList<Anfitrion> lista = JSwingUtilsVivienda.getInstance().getListaAnfitrionBD();
        for (Anfitrion x : lista) {
            if(anfitrion == x.getId()){
                return x.getIdentificador();
            }
        }
        return "-";
    }
    
    /* Metodo para recuperar la llave foránea(ID) a partir de la cadena ingresada */
    public static int getCiudadFK(String ciudad) {
        ArrayList<Ciudad> lista = JSwingUtilsVivienda.getInstance().getListaCiudadBD();
        for (Ciudad x : lista) {
            if(ciudad.compareToIgnoreCase(x.getNombre()) == 0){
                return x.getId();
            }
        }
        return 0;
    }

    /* Metodo para recuperar la cadena partir de la llave foránea(ID) ingresada */    
    public static String getCiudad(int ciudad){
        ArrayList<Ciudad> lista = JSwingUtilsVivienda.getInstance().getListaCiudadBD();
        for (Ciudad x : lista) {
            if(ciudad == x.getId()){
                return x.getNombre();
            }
        }
        return "-";
    }
    
    /* Metodo para recuperar la llave foránea(ID) a partir de la cadena ingresada */
    public static int getTipoViviendaFK(String tipoVivienda) {
        ArrayList<ViviendaTipo> lista = JSwingUtilsVivienda.getInstance().getListaViviendaTipoBD();
        for (ViviendaTipo x : lista) {
            if(tipoVivienda.compareToIgnoreCase(x.getNombre()) == 0){
                return x.getId();
            }
        }
        return 0;
    } 
    
    /* Metodo para recuperar la cadena partir de la llave foránea(ID) ingresada */    
    public static String getTipoVivienda(int tipoVivienda){
        ArrayList<ViviendaTipo> lista = JSwingUtilsVivienda.getInstance().getListaViviendaTipoBD();
        for (ViviendaTipo x : lista) {
            if(tipoVivienda == x.getId()){
                return x.getNombre();
            }
        }
        return "-";
    } 
}
