package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HotelDAO {
    public void saveHotel(Hotel hotel) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(hotel);
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

    public void deleteHotel(int tripId) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Hotel hotel = session.createQuery("FROM Hotel WHERE tripId = :tripId", Hotel.class)
                             .setParameter("tripId", tripId)
                             .uniqueResult();
            if (hotel != null) {
                session.remove(hotel);
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

