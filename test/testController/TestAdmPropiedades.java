/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testController;

import controllerDAO.AdmViviendasDAO;
import java.util.ArrayList;
import model.Vivienda;

/**
 *
 * @author N1L0XD
 */
public class TestAdmPropiedades {
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
        AdmViviendasDAO.insertar(new Vivienda
        ("000000004", "TOUR INTERNATIONAL", "TOURINTERNATIONAL@GMAIL.COM", "SUR GUAYAQUIL", 10, 1, 1, 3, 1));
    }

    private static void consultarTabla() {
        ArrayList<Vivienda> ls1 = AdmViviendasDAO.consultar();
        if(ls1!=null && ls1.size()>0){
            for (Vivienda persona : ls1) {
                System.out.println(persona.toString());
            }
        }else{
            System.out.println("lista nula");
        } 
    }
}
