/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testModels;

import java.util.Date;
import model.Anfitrion;
import model.Huesped;

/**
 *
 * @author N1L0XD
 */
public class TestPersona {
    public static void main(String[] args) {
        //Crear objeto de tipo Anfitrion 
        System.out.println(new Anfitrion().toString());
        System.out.println(new Anfitrion("0931600548", "Danilo Miguel", "Pin Veloz", new Date(), "daniloski_@gmail.com", "Habilitado", 0, 0, 0).toString());
        
        //Crear objeto de tipo Huesped 
        System.out.println(new Huesped().toString());
        System.out.println(new Huesped("0931600548", "Danilo Miguel", "Pin Veloz", new Date(), "daniloski_@gmail.com", "Habilitado", 0, 0, 0).toString());
    }
}
