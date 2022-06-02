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

    Connection conn= Util.connect();
    Statement stat;
    List<User> user;

    public UserDaoJDBCImpl() throws SQLException, ClassNotFoundException {
        user = new ArrayList<>();
    }

    public void createUsersTable() throws SQLException, ClassNotFoundException {
        stat = conn.createStatement();
        stat.executeUpdate("CREATE TABLE IF NOT EXISTS user1 (id INT(64) NOT NULL AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age INT(64), PRIMARY KEY(id));");
        stat.close();
    }

    public void dropUsersTable() throws SQLException {
        stat = conn.createStatement();
        stat.executeUpdate("drop TABLE IF EXISTS User1");
        stat.close();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        stat = conn.createStatement();
        stat.executeUpdate("insert into user1 (name, lastName, age) VALUES (\""+ name + "\",\"" + lastName + "\","+ age + ")");
        stat.close();
    }

    public void removeUserById(long id) throws SQLException {
        stat = conn.createStatement();
        stat.executeUpdate("DELETE FROM user1 WHERE id = id");
        stat.close();
    }

    public List<User> getAllUsers() throws SQLException {
        stat = conn.createStatement();
        ResultSet rs1 = stat.executeQuery("select * from user1");
        user = new ArrayList<>();
        User user2 = new User();
        while(rs1.next()) {
            user2.setName(rs1.getString("name"));
            user2.setLastName(rs1.getString("lastName"));
            user2.setAge(rs1.getByte("age"));
            user2.setId(1L);
            user.add(user2);
        }
        stat.close();
        return user;
    }

    public void cleanUsersTable() throws SQLException {
        stat = conn.createStatement();
        stat.executeUpdate("DELETE FROM user1");
        stat.close();
    }
}
