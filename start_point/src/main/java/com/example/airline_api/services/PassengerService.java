package com.example.airline_api.services;

import com.example.airline_api.models.AddFlightDTO;
import com.example.airline_api.models.AddPassengerDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FlightRepository flightRepository;
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).get();
    }

    public Passenger addPassenger(AddPassengerDTO addPassengerDTO){
        Passenger passenger = new Passenger(addPassengerDTO.getName(),addPassengerDTO.getEmail());

        for (Long flightID : addPassengerDTO.getFlightIDs()){
            Flight flight = flightRepository.findById(flightID).get();
            flight.addPassengers(passenger);
        }

        passengerRepository.save(passenger);
        return passenger;
    }
}
