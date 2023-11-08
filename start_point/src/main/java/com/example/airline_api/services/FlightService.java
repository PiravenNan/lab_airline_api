package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;


    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).get();
    }

    public Flight addFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

//    public Flight addFlight(FlightDTO flightDTO) {
//       Flight newFlight =  new Flight(flightDTO.getDestination(),flightDTO.getCapacity(),flightDTO.getDepartureDate(),flightDTO.getDepartureTime());
//       for (Long passengerID : flightDTO.getPassengerIds()){
//           newFlight.addPassengers(passengerRepository.getById(passengerID));
//       }
//       return newFlight;
//    }
    @Transactional
    public Flight addPassengerToFlight(Long flightID,FlightDTO flightDTO) {
        Flight flight = flightRepository.findById(flightID).get();

        for (Long passengerID : flightDTO.getPassengerIds()){
            if (flight.getPassengers().size()<flight.getCapacity()){
                Passenger passenger = passengerRepository.findById(passengerID).get();
                passenger.addFlights(flight);
                flight.addPassengers(passenger);
            }

        }
        flightRepository.save(flight);
        return flight;
    }
    public void cancelFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> findByDestination(String destination){
        return flightRepository.findByDestinationEquals(destination);
    }
}
