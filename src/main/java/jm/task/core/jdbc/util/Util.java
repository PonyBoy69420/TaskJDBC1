package jm.task.core.jdbc.util;

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
}
