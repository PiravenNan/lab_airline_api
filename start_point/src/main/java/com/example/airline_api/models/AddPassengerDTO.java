package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class AddPassengerDTO {

    private String name;
    private String email;
    private List<Long> flightIDs;

    public AddPassengerDTO(String name, String email, List<Long> flightIDs) {
        this.name = name;
        this.email = email;
        this.flightIDs = flightIDs;
    }

    public AddPassengerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getFlightIDs() {
        return flightIDs;
    }

    public void setFlightIDs(List<Long> flightIDs) {
        this.flightIDs = flightIDs;
    }
}
