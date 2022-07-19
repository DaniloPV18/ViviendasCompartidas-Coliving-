/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testUtilities;

import java.util.Date;
import model.Persona;
import utilities.Servicios;

/**
 *
 * @author N1L0XD
 */
public class TestServicios {
    public static void main(String[] args) {
        Persona p = Servicios.personaUpperCase(new Persona("00000001", "melant sedasd", "weeee PRUEBA", new Date(), "test@GMAIL.COM", "habilitado", 1, 1, 1));
        System.out.println(p.toString());
    }
}
