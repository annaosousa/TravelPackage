package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AirlineDAO {
    public void saveAirline(Airline airline) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(airline);
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

    public void deleteAirline(int tripId) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Airline airline = session.createQuery("FROM Airline WHERE tripId = :tripId", Airline.class)
                             .setParameter("tripId", tripId)
                             .uniqueResult();
            if (airline != null) {
                session.delete(airline);
            }

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

