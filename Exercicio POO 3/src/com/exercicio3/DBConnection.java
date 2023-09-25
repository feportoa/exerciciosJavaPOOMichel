package com.exercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/test_bank";
    private static final String user = "12345";
    private static final String password = "12345";
    private static Connection conn;

    public static Connection getConn() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException err) {
            System.out.println(err);
            return null;
        }
    }

}
