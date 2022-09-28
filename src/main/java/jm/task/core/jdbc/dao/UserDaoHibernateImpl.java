package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class UserDaoHibernateImpl implements UserDao {

    public static final SessionFactory sessionFactory = Util.getSessionFactory();



    public UserDaoHibernateImpl() throws SQLException, ClassNotFoundException {

    }


    @Override
    public void createUsersTable() {
        Transaction trans = null;
        Session session = sessionFactory.openSession();
        try{
            trans= session.getTransaction();
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS User3 (id serial primary key, name VARCHAR(50), lastName VARCHAR(50), age integer);").executeUpdate();
            if(!trans.wasCommitted())trans.commit();
            System.out.println("Tablica sozdana");
        }catch(HibernateException e){
            trans.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction trans = null;
        Session session = sessionFactory.openSession();
        try{
            trans= session.getTransaction();
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS User3").executeUpdate();
            if(!trans.wasCommitted())trans.commit();
            System.out.println("Tablica udalena");
        }catch(HibernateException e){
            trans.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction trans = null;
        User user = new User(name,lastName,age);
        Session session = sessionFactory.openSession();
        try{
            trans= session.getTransaction();
            session.beginTransaction();
            session.save(user);
            if(!trans.wasCommitted())
                trans.commit();
            System.out.println("User dobavlen");
        }catch(HibernateException e){
            trans.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction trans = null;
        Session session = sessionFactory.openSession();
        try{
            trans= session.getTransaction();
            session.beginTransaction();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            if(!trans.wasCommitted())
                trans.commit();
            System.out.println("User udalen");
        }catch(HibernateException e){
            trans.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction trans = null;
        List<User> user = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try{
            trans= session.getTransaction();
            session.beginTransaction();
            user = session.createQuery("FROM User").list();
            if(!trans.wasCommitted())
                trans.commit();
            System.out.println("User udalen");
        }catch(HibernateException e){
            trans.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return user;
    }

    @Override
    public void cleanUsersTable() {
        Transaction trans = null;
        Session session = sessionFactory.openSession();
        try{
            trans= session.getTransaction();
            session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            if(!trans.wasCommitted())
                trans.commit();
            System.out.println("Tabliza Ochishena");
        }catch(HibernateException e){
            trans.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
}



