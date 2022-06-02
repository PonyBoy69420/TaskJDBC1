package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl a = new UserDaoJDBCImpl();

    public UserServiceImpl() throws SQLException, ClassNotFoundException {
    }

    public void createUsersTable() throws SQLException, ClassNotFoundException {
        a.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        a.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        a.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) throws SQLException {
        a.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return a.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        a.cleanUsersTable();
    }
}
