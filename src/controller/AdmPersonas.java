/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.Conexion;
import java.sql.Connection;

/**
 *
 * @author N1L0XD
 */
public class AdmPersonas {

    private static final Connection cn = Conexion.getConnection();

    public AdmPersonas() {
        System.out.println(getCn());
    }

    public static Connection getCn() {
        return cn;
    }

}
