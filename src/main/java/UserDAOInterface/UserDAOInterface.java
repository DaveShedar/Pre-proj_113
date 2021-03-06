package UserDAOInterface;

import User.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDAOInterface {

    public void addUser(User user) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
    public User getUserById(int id);
    public List< User > getAllUsers();
    public boolean deleteUser(int id) throws SQLException;
}
