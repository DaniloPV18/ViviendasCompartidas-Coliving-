/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testController;

import controllerDAO.AdmAnfitrionesDAO;
import java.util.ArrayList;
import java.util.Date;
import model.Anfitrion;

/**
 *
 * @author N1L0XD
 */
public class TestAdmAnfitriones {
    public static void main(String[] args) {
        insertarDatosPrueba();      
        
        consultarTabla();
               
        AdmAnfitrionesDAO.actualizar("1561651651", new Anfitrion("1212", "DANILO MIGUEL", "PIN VELOZ", new Date(), "DANILO@GMAIL.COM", "HABILITADO", 1, 1, 1));
        
        AdmAnfitrionesDAO.eliminar("1561651651");
                
        consultarTabla();
    }

    private static void insertarDatosPrueba() {
        AdmAnfitrionesDAO.insertar(new Anfitrion("00000001", "MELANY PRUEBA", "PRUEBA PRUEBA", new Date(), "PRUEBA@GMAIL.COM", "HABILITADO", 1, 1, 1));
        AdmAnfitrionesDAO.insertar(new Anfitrion("0931600548", "ANGEL MIGUEL", "PIGUAVE GUAGUA", new Date(), "ANGEL@GMAIL.COM", "HABILITADO", 1, 1, 1));
        AdmAnfitrionesDAO.insertar(new Anfitrion("0984844848", "MICHAEL JOSEPH", "JOESTAR GUAGUA", new Date(), "MICHAEL@GMAIL.COM", "HABILITADO", 1, 1, 1));
        AdmAnfitrionesDAO.insertar(new Anfitrion("0941848487", "ANGEL PALOMINO", "PIGUAVE GUAGUA", new Date(), "ANGEL@GMAIL.COM", "HABILITADO", 1, 1, 1));
        AdmAnfitrionesDAO.insertar(new Anfitrion("0984816584", "JONATHAN PALOMINO", "JOESTAR GUAGUA", new Date(), "JONATHAN@GMAIL.COM", "HABILITADO", 1, 1, 1));
        AdmAnfitrionesDAO.insertar(new Anfitrion("0936878465", "JOTARO KOUJO", "PIGUAVE GUAGUA", new Date(), "JOTARO@GMAIL.COM", "HABILITADO", 1, 1, 1));  
    }

    private static void consultarTabla() {
        ArrayList<Anfitrion> ls1 = AdmAnfitrionesDAO.consultar();
        if(ls1!=null && ls1.size()>0){
            for (Anfitrion persona : ls1) {
                System.out.println(persona.toString());
            }
        }else{
            System.out.println("lista nula");
        } 
    }
}
