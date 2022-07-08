package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Util.getCon();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Masha", "Ivanova", (byte) 20);
        userDao.saveUser("Vanya", "Petrov", (byte) 25);
        userDao.saveUser("Vasiliy", "Sidorov", (byte) 31);
        userDao.saveUser("Jenya", "Okladnikov", (byte) 38);

        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
