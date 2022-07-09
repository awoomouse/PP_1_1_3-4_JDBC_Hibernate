package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoHibernateImpl();

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
