/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author la paix
 */
public class Flight implements Serializable {

    private Long flightId;

    private Airline airline;

    private String flightNumber; // Unique identifier for the flight

    private Country departureCity;

    private Country arrivalCity;

    private Date departureDateTime;
    private Date arrivalDateTime;

    private int totalSeats;
    private int availableSeats;

    private double basePrice; // Base price for the flight

    // Other fields specific to the Flight entity
    private List<Booking> bookings;

    public Flight() {
    }

    public Flight(Long flightId, Airline airline, String flightNumber, Country departureCity, Country arrivalCity, Date departureDateTime, Date arrivalDateTime, int totalSeats, int availableSeats, double basePrice, List<Booking> bookings) {
        this.flightId = flightId;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.basePrice = basePrice;
        this.bookings = bookings;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Country getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(Country departureCity) {
        this.departureCity = departureCity;
    }

    public Country getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(Country arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    
}
