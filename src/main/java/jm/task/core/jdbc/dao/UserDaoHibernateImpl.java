package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }
    Session session;

    @Override
    public void createUsersTable() {
        session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "CREATE TABLE user_table (Id bigint PRIMARY KEY AUTO_INCREMENT, user_name VARCHAR(20), user_lastname VARCHAR(30), user_age INT)";

        session.createSQLQuery(hql).addEntity(User.class).executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "DROP TABLE User";

        Query query = session.createSQLQuery(sql).addEntity(User.class);

        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User(name, lastName, age);
        session.save(user);

        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);

        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User").getResultList();

        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public void cleanUsersTable() {
        session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE FROM User w";

        session.createQuery(hql).executeUpdate();

        transaction.commit();
        session.close();
    }
}
