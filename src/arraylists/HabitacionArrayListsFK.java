/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylists;

import controllerDAO.AdmViviendasDAO;
import java.util.ArrayList;
import model.HabitacionTipo;
import model.Vivienda;
import utilities.Servicios;

/**
 *
 * @author N1L0XD
 */
public class HabitacionArrayListsFK {    
      
    public static String getHabitacionTipo(int idVivienda) {
        ArrayList<HabitacionTipo> lista = Servicios.consultarTHabitacionTipo();
        for (HabitacionTipo x : lista) {
            if(x.getId() == idVivienda){
                return x.getNombre();
            }
        }
        return "-";
    }
    
    public static String getVivienda(int id){
        ArrayList<Vivienda> lista = AdmViviendasDAO.consultar();
        for (Vivienda x : lista) {
            if(id == x.getId()){
                return x.getIdentificador();
            }
        }
        return "-";
    } 
}
