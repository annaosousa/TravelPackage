package com.example;

import com.example.Trip;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.HibernateUtil;

public class TripDAO {
    public void saveTrip(Trip trip) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(trip);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

