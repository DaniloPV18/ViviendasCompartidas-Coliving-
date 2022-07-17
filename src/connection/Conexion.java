/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author N1L0XD
 */
public class Conexion {

    private static Connection conn = null;
    private static String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String user = "C##USUARIO_COLIVING";
    private static String pass = "USUARIO_COLIVING";
    private static PreparedStatement pst = null;

    public Conexion() {
        getConnection();
    }

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(myDB, user, pass);
            System.out.println("Conexion exitosa");
            return conn;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void desconectar() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet consultar(String sentence) {
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(sentence);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }     
}
