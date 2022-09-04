/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylists;

import java.util.ArrayList;
import model.HabitacionTipo;
import utilities.Servicios;

/**
 *
 * @author N1L0XD
 */
public class HabitacionArrayLists {    
      
    public static String getHabitacionTipo(int idVivienda) {
        ArrayList<HabitacionTipo> lista = Servicios.consultarTHabitacionTipo();
        for (HabitacionTipo x : lista) {
            if(x.getId() == idVivienda){
                return x.getNombre();
            }
        }
        return "-";
    }
}
