package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sqlCommand = "CREATE TABLE user_table (Id INT PRIMARY KEY AUTO_INCREMENT, user_name VARCHAR(20), user_lastname VARCHAR(30), user_age INT)";
        Connection con = Util.getCon();
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sqlCommand);
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public void dropUsersTable() {
        String sqlCommand = "DROP TABLE user_table";
        Connection con = Util.getCon();
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sqlCommand);
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sqlCommand = "INSERT user_table(user_name, user_lastname, user_age) VALUES (\'" + name + "\', \'" + lastName + "\', " + age + ")";
        Connection con = Util.getCon();
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sqlCommand);
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public void removeUserById(long id) {
        String sqlCommand = "DELETE FROM user_table WHERE Id=" + id;
        Connection con = Util.getCon();
        try {
            Statement st = con.createStatement();
            st.executeUpdate(sqlCommand);
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public List<User> getAllUsers() {
        String sqlCommand = "SELECT Id, user_name, user_lastname, user_age FROM user_table";
        List<User> list = new ArrayList<>();
        Connection con = Util.getCon();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                User user = new User();
                user.setId((long) rs.getInt(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge((byte) rs.getInt(4));
                list.add(user);
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    public void cleanUsersTable() {

        String sqlCommand = "TRUNCATE TABLE user_table";
        Connection con = Util.getCon();
        try {
            Statement st = con.createStatement();
            st.execute(sqlCommand);
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }
}
