package db;

import models.HibernateUtil;
import models.Writer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
