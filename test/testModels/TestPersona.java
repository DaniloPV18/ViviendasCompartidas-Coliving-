/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testModels;

import java.util.Date;
import model.Persona;

/**
 *
 * @author N1L0XD
 */
public class TestPersona {
    public static void main(String[] args) {
        System.out.println(new Persona().toString());
        System.out.println(new Persona("0931600548", "Danilo Miguel", "Pin Veloz", new Date(), "daniloski_@gmail.com", "Habilitado", 0, 0, 0).toString());
    }
}
