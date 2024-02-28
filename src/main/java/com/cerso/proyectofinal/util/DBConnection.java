
package com.cerso.proyectofinal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static Connection connection=null;
    private static final String URL="jdbc:mysql://localhost:3306/empresa";
    private static final String USER="root";
    private static final String PASSWORD="root";
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            connection=DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected");
        } catch (SQLException|ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return connection;
    }
    
    //prueba de conexion a la base de datos
    public static void main(String[] args) {
        
        DBConnection.getConnection();
    }
    
}
