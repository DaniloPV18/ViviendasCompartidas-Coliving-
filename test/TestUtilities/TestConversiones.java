/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestUtilities;

import utilities.Conversiones;

/**
 *
 * @author N1L0XD
 */
public class TestConversiones {
    public static void main(String[] args) {
        System.out.println(Conversiones.getFecha(new java.util.Date()));
        System.out.println(Conversiones.getFecha(Conversiones.getFecha(new java.util.Date())));
        
    }
}
