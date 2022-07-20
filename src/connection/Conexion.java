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
    private static String myDB = "coliving_test";
    private static String user = "root";
    private static String pass = "root";
    private static String host = "127.0.0.1";
    private static int port = 3306;
    
    public Conexion() {
        getConnection();
    }
    
    //Establecer conexion con BD MySQL
    public static Connection getConnection() {
        try {
            String connectionUrl = "jdbc:mysql://"+host+":"+port+"/"+ myDB;   				         
            //String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/coliving";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl,user,pass);            
            System.out.println("Conexion abierta");
            return conn;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //Cerrar conexion con BD MySQL
    public static void desconectar() {
        try {
            conn.close();
            System.out.println("Conexion cerrada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
}
