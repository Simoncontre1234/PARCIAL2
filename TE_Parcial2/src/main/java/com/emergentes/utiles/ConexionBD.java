package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_eventos";
    static String usuario = "root";
    static String password = "";

   protected Connection conn = null;

    public ConexionBD() {
        try {
            // Especificación del driver
            Class.forName(driver);
            // Establece la conexión a la base de datos
            conn = DriverManager.getConnection(url, usuario, password);
            // Verificar si la conexión fue exitosa
            if (conn != null) {
                System.out.println("Conexión Exitosa :" + conn);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL" + ex.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
