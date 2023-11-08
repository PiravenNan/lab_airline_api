package com.example.airline_api.controllers;

import com.example.airline_api.models.AddFlightDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;


    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){

        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        return new ResponseEntity<>(flightService.getFlightById(id),HttpStatus.OK);
    }
    @GetMapping(value = "/destination/{destination}")
    public ResponseEntity<List<Flight>> findByDestination(@PathVariable String destination){
        return new ResponseEntity<>(flightService.findByDestination(destination),HttpStatus.OK);
    }


    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody AddFlightDTO addFlightDTO){
        Flight newFlight = flightService.addFlight(addFlightDTO);
        return new ResponseEntity<>(newFlight,HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{flightID}")
    public ResponseEntity<Flight> addPassengerToFlight(@PathVariable Long flightID,@RequestBody FlightDTO flightDTO){
        Flight newFlight = flightService.addPassengerToFlight(flightID,flightDTO);
        return new ResponseEntity<>(newFlight,HttpStatus.CREATED);
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        flightService.cancelFlight(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

}
