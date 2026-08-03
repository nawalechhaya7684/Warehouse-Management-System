package com.acc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getDBConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parcelmanag"
                    + "?useSSL=false"
                    + "&allowPublicKeyRetrieval=true"
                    + "&serverTimezone=UTC",
                     "root", "dbms2005");
            
        } catch (Exception e) {
            System.err.println("DB Error: " + e.getMessage());
        }
        return con;
    }

}