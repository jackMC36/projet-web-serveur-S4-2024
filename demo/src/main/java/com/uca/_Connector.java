package com.uca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _Connector {
    private static Connection connection;

    public static Connection getInstance() {
        if (connection == null) {
            try {
                Class.forName("org.h2.Driver");
                connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}