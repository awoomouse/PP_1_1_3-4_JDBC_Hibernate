package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connection;

//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            connection = DriverManager.getConnection(url, user, password);
//            Statement st = connection.createStatement();
//            String sqlCommandCreate = "CREATE TABLE user_table (Id INT PRIMARY KEY AUTO_INCREMENT, user_name VARCHAR(20), user_lastname VARCHAR(30), user_age INT)";
//            String sqlCommand = "DROP TABLE user_table";
//            st.executeUpdate(sqlCommand);
//            connection.close();
//            System.out.println("done!");
//        } catch (SQLException e) {
//            System.out.println("sql except");
//        } catch (ClassNotFoundException e) {
//            System.out.println("class not found");
//        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException e) {
//            System.out.println("chto-to sluchilos' s Class.forname()");
//        }
//    }
    public static Connection getCon() {
        try {
            return connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
        }
        return connection;
    }
}
