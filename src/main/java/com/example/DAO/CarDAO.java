package com.example.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.HibernateUtil;
import com.example.model.Car;

public class CarDAO {
    public void saveCar(Car car) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getCarsSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(car);
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

    public void deleteCar(int tripId) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getCarsSessionFactory().openSession();
            transaction = session.beginTransaction();

            Car car = session.createQuery("FROM Car WHERE tripId = :tripId", Car.class)
                             .setParameter("tripId", tripId)
                             .uniqueResult();
            if (car != null) {
                session.delete(car);
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

