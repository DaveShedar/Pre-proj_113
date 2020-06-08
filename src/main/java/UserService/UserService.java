package UserService;

import java.util.List;

import Dao.UserHibernateDAO;
import User.User;

import java.sql.SQLException;

public class UserService {

    private static UserService userService;

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void addUser(User user) throws SQLException {
        UserHibernateDAO.getUserHibernateDAO().addUser(user);
    }

    public boolean updateUser(User user) throws SQLException {
        return UserHibernateDAO.getUserHibernateDAO().updateUser(user);
    }

    public User getUserById(int id) {
        return UserHibernateDAO.getUserHibernateDAO().getUserById(id);
    }

    public List< User > getAllUsers() {
        return UserHibernateDAO.getUserHibernateDAO().getAllUsers();
    }

    public boolean deleteUser(int id) throws SQLException {
        return UserHibernateDAO.getUserHibernateDAO().deleteUser(id);
    }
}
