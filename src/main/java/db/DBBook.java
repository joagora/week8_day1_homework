package db;

import models.Book;
import models.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBBook {

    private static Transaction transaction;
    private static Session session;

    public static void save(Book book) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
        catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }

    }

    public static List<Book> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Book> results = null;
        try {
            Criteria cr = session.createCriteria(Book.class);
            results = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
