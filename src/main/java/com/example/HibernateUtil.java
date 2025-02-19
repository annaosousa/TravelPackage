package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static final SessionFactory carsSessionFactory = buildCarsSessionFactory();
    private static final SessionFactory flightsSessionFactory = buildFlightsSessionFactory();
    private static final SessionFactory hotelsSessionFactory = buildHotelsSessionFactory();
    private static final SessionFactory tripsSessionFactory = buildTripsSessionFactory();

    private static SessionFactory buildCarsSessionFactory() {
        return new Configuration().configure("hibernate-car.cfg.xml").buildSessionFactory();
    }

    private static SessionFactory buildFlightsSessionFactory() {
        return new Configuration().configure("hibernate-flight.cfg.xml").buildSessionFactory();
    }

    private static SessionFactory buildHotelsSessionFactory() {
        return new Configuration().configure("hibernate-hotel.cfg.xml").buildSessionFactory();
    }

    private static SessionFactory buildTripsSessionFactory() {
        return new Configuration().configure("hibernate-trip.cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getCarsSessionFactory() {
        return carsSessionFactory;
    }

    public static SessionFactory getFlightsSessionFactory() {
        return flightsSessionFactory;
    }

    public static SessionFactory getHotelsSessionFactory() {
        return hotelsSessionFactory;
    }

    public static SessionFactory getTripsSessionFactory() {
        return tripsSessionFactory;
    }

    public static void shutdown() {
        getCarsSessionFactory().close();
        getFlightsSessionFactory().close();
        getHotelsSessionFactory().close();
        getTripsSessionFactory().close();
    }
}

