package Dao;

import User.User;
import UserDAOInterface.UserDAOInterface;
import org.hibernate.Session;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAOInterface {
    private Session session = DBHelper.getSessionFactory().openSession();

//    public UserHibernateDAO(Session session) {
//        this.session = session;
//    }

    public UserHibernateDAO() {
    }

    @Override
    public void addUser(User user) throws SQLException {
        session.save(user);
        session.flush();
        session.clear();
    }

    @Override
    public User getUserById(int id) {
        User user = (User) session.get(User.class, id);
        session.flush();
        session.clear();
        return user;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List< User > getAllUsers() {
        session.getTransaction().begin();
        List< User > list = session.createQuery(" FROM User").list();
        session.getTransaction().commit();
        session.flush();
        session.clear();
        return list;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        session.delete(session.get(User.class, id));
        session.flush();
        session.clear();
        return true;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {

        session.update(user);
        session.flush();
        session.clear();
        return true;
    }
}
