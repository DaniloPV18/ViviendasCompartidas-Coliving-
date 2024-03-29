/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraylists;

import components.JSwingUtilsPagos;
import controllerDAO.AdmHabitacionesDAO;
import controllerDAO.AdmPagosDAO;
import controllerDAO.AdmViviendasDAO;
import java.util.ArrayList;
import model.Habitacion;
import model.Pago;
import model.PagoMetodo;

/**
 *
 * @author NILOXD
 */
public class PagosArrayListsFK {
    
    /* Metodo para recuperar la llave foránea(ID) a partir de la cadena ingresada */
    public static int getMetodoPagoFK(String nombre){
        ArrayList<PagoMetodo> lista = JSwingUtilsPagos.getInstance().getListaPagoMetodoBD();
        for (PagoMetodo x : lista) {
            if(nombre.compareToIgnoreCase(x.getNombre()) == 0){
                return x.getId();
            }
        }
        return 0;
    }
    
    public static int getIdHabitacion(int codigoHabitacion, int idVivienda){
        ArrayList<Habitacion> lista = AdmHabitacionesDAO.consultar();
        for (Habitacion x : lista) {
            if(x.getPropiedad() == idVivienda && x.getIdentificador()== codigoHabitacion){
                return x.getId();
            }
        }
        return 0;
    }
}
