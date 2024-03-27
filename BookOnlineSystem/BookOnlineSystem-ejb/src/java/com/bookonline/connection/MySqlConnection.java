package com.bookonline.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ten_co_so_du_lieu";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
