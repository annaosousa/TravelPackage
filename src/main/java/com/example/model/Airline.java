package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flights")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "trip_id", nullable = false)
    private int tripId;

    @Column(name = "flight_number", nullable = false)
    private String flightNumber;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    // Getter and Setter for origin
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
