package com.data.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD = "snd21804@";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.fillInStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn, CallableStatement cs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.fillInStackTrace();
            }
        }
        if (cs != null) {
            try {
                cs.close();
            } catch (SQLException e) {
                e.fillInStackTrace();
            }
        }
    }
}

