package jm.task.core.jdbc;


import jm.task.core.jdbc.util.Util;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn= Util.connect();
        Statement stat = conn.createStatement();
        stat.executeUpdate("drop TABLE IF EXISTS User1");
        stat.executeUpdate("CREATE TABLE IF NOT EXISTS user1 (id INT(64) NOT NULL AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age INT(64), PRIMARY KEY(id));");
        stat.executeUpdate("insert into user1 (name, lastName, age) VALUES ('Dima','Abashidze',20),('Ivan','Armaturovich',30),('Abob','Abobovich',40),('Biba','Bobovich',50)");
        ResultSet rs1 = stat.executeQuery("select * from user1");
        while(rs1.next()) {
            System.out.println(rs1.getInt(1));
            System.out.println(rs1.getString(2));
            System.out.println(rs1.getString(3));
            System.out.println(rs1.getInt(4));
            System.out.println("-----------------------");
        }
        stat.executeUpdate("DELETE FROM user1 WHERE id = 3");
        stat.executeUpdate("DELETE FROM user1");


    }
}

