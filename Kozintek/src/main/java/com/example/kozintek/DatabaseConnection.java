package com.example.kozintek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    public Connection databaseLink;

     public Connection getConnection() {
         String databaseUser = "root" ;
         String databasePassword = "12345678" ;
         String url = "jdbc:mysql://localhost/Kozintek" ;
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
         }catch ( Exception e ) {
             e.printStackTrace();
         }
         return databaseLink;
     }
}
