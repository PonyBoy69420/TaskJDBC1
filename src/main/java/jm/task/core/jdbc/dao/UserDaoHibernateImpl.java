package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@javax.persistence.Entity
@Table(name = "User3")
public class UserDaoHibernateImpl implements UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name="age")
    private int age;


    Connection conn= Util.connectHib();
    SessionFactory sessionFactory = new Configuration().buildSessionFactory();

    Session session = null;

    public UserDaoHibernateImpl() throws SQLException, ClassNotFoundException {

    }


    @Override
    public void createUsersTable() {
        try(Statement stat = conn.createStatement()) {
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS User3 (id INT(64) NOT NULL AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age INT(64), PRIMARY KEY(id));");
        }catch(Exception e){
            System.out.println("Error");
        }
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = new User(name,lastName,age);
        session.save(user);
        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }

    @Override
    public String toString(){
        return String.format("User3 [id = %d, name = %s, lastName = %s, age = %d]",id ,name, lastName,age);
    }
}
