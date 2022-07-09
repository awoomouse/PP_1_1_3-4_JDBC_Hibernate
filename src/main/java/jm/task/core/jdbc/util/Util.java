package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connection;

    public static Connection getCon() {
        try {
            return connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
        }
        return connection;
    }
}
