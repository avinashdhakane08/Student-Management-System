package org.example.Config;

import java.sql.*;

public class DBConfig {

    private static final String url = System.getenv("DB_URL");
    private static final String userName = System.getenv("DB_USERNAME");
    private static final String password = System.getenv("DB_PASSWORD");



    public static Statement getInstance() {


        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            return statement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

