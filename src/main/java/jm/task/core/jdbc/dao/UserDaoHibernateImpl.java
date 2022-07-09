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


    @Override
    public void createUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "CREATE TABLE user_table (Id bigint PRIMARY KEY AUTO_INCREMENT, user_name VARCHAR(20), user_lastname VARCHAR(30), user_age INT)";

        Query query = session.createSQLQuery(sql).addEntity(User.class);

        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DROP TABLE user_table";

        Query query = session.createSQLQuery(sql).addEntity(User.class);

        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        User user = new User(name, lastName, age);
        session.save(user);

        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, id);
        session.delete(user);

        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<User> list = session.createQuery("FROM User").getResultList();

        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "TRUNCATE TABLE user_table";

        Query query = session.createSQLQuery(sql).addEntity(User.class);

        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
