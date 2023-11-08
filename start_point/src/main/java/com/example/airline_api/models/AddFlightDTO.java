package com.example.airline_api.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AddFlightDTO {

    private String destination;
    private int capacity;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private List<Long> passengerIDs;

    public AddFlightDTO(String destination, int capacity, LocalDate departureDate, LocalTime departureTime, List<Long> passengerIDs) {
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.passengerIDs = passengerIDs;
    }

    public AddFlightDTO() {
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public List<Long> getPassengerIDs() {
        return passengerIDs;
    }

    public void setPassengerIDs(List<Long> passengerIDs) {
        this.passengerIDs = passengerIDs;
    }
}
