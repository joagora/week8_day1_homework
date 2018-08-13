package db;

import models.HibernateUtil;
import models.Writer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBWriter {

    private static Transaction transaction;
    private static Session session;

    public static void save(Writer writer){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(writer);
            transaction.commit();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Writer> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Writer> results = null;
        try {
            Criteria cr = session.createCriteria(Writer.class);
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Writer findById(int id){
        Writer foundWriter = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Writer.class);
            cr.add(Restrictions.eq("id", id));
            foundWriter = (Writer) cr.uniqueResult();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return foundWriter;
    }

    public static void update(Writer writer){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(writer);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
