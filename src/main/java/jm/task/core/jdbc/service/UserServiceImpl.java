package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl a = new UserDaoJDBCImpl();
    UserDaoHibernateImpl b = new UserDaoHibernateImpl();

    public UserServiceImpl() throws SQLException, ClassNotFoundException {
    }

    public void createUsersTable() throws SQLException, ClassNotFoundException {
        b.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        b.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        b.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) throws SQLException {
        b.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return b.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        b.cleanUsersTable();
    }
}
