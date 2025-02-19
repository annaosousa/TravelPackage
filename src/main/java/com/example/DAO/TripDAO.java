package com.example.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.HibernateUtil;
import com.example.model.Trip;

public class TripDAO {
    public void saveTrip(Trip trip) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getTripsSessionFactory().openSession();
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

    public void updateTripStatus(int id, String status) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getTripsSessionFactory().openSession();
            transaction = session.beginTransaction();

            Trip trip = session.createQuery("FROM Trip WHERE id = :id", Trip.class)
                             .setParameter("id", id)
                             .uniqueResult();
            if (trip != null) {
                trip.setStatus(status); 
                session.update(trip);
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

