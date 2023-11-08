package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        //Flights
        LocalDate departureDate = LocalDate.of(2023, 11, 8);
        LocalTime departureTime = LocalTime.parse("00:08");

        Flight flightOne = new Flight("Sunderland",1000,departureDate,departureTime);

        LocalDate departureDate2 = LocalDate.of(2023, 11, 10);
        LocalTime departureTime2 = LocalTime.parse("00:09");

        Flight flightTwo = new Flight("Paris",2,departureDate2,departureTime2);

        LocalDate departureDate3 = LocalDate.of(2023, 11, 18);
        LocalTime departureTime3 = LocalTime.parse("10:28");
        Flight flightThree = new Flight("Sunderland",1000,departureDate3,departureTime3);

        flightRepository.save(flightOne);
        flightRepository.save(flightTwo);
        flightRepository.save(flightThree);

        //passengers
        Passenger Bob = new Passenger("Bob","B@hotmail.com");
        Passenger John = new Passenger("John","J@gmail.com");
        Passenger Sally = new Passenger("Sally","S@protonmail.me");
        Passenger Betty = new Passenger("Betty","B@Yahoo.com");

        passengerRepository.save(Bob);
        passengerRepository.save(Betty);
        passengerRepository.save(Sally);
        passengerRepository.save(John);

    }
}
