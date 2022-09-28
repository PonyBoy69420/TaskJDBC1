package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import jm.task.core.jdbc.model.User;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util{
    private static String userName = "root";
    private static String password = "1234";
    private static String connectionURL="jdbc:mysql://localhost:3306/mysql?useUnicode=true&serverTimezone=UTC";;// реализуйте алгоритм здесь
    public static Connection connect() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection(connectionURL, userName, password);
            System.out.println("We're connected");
            return connection;// реализуйте настройку соеденения с БД

    }
    private static String userNameHib = "postgres";
    private static String passwordHib = "admin";
    private static String connectionURLHib="jdbc:postgresql://localhost:5432/postgres?currentSchema = Hib";;// реализуйте алгоритм здесь
    public static Connection connectHib() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection(connectionURL, userName, password);
        System.out.println("We're connected");
        return connection;
    }


    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().addAnnotatedClass(User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

}
