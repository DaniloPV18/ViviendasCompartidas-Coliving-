/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testController;

import controller.AdmHabitacionesDataBase;
import java.util.ArrayList;
import model.Habitacion;

/**
 *
 * @author N1L0XD
 */
public class TestAdmHabitaciones {
    public static void main(String[] args) {
//        insertarDatosPrueba();      
        
//        consultarTabla();
               
//        AdmPropiedadesDataBase.actualizar(44, new Persona("1561651651", "DANILO MIGUEL", "PIN VELOZ", new Date(), "DANILO@GMAIL.COM", "HABILITADO", 1, 1, 1));
//        
//        AdmPropiedadesDataBase.eliminar("000000003");
//                
        consultarTabla();
    }

    private static void insertarDatosPrueba() {
        AdmHabitacionesDataBase.insertar(new Habitacion
        (1, 4, true, 50,  1, 1, 1, 1));
    }

    private static void consultarTabla() {
        ArrayList<Habitacion> ls1 = AdmHabitacionesDataBase.consultar();
        if(ls1!=null && ls1.size()>0){
            for (Habitacion h : ls1) {
                System.out.println(h.toString());
            }
        }else{
            System.out.println("lista nula");
        } 
    }
}
