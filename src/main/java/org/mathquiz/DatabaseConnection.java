package org.mathquiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5434/postgres";
    private static final String USER = "postgres"; // Replace with your PostgreSQL username
    private static final String PASSWORD = "Apple132."; // Replace with your PostgreSQL password

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }
}

