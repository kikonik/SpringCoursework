package com.example.system.repository;

import com.example.system.entity.Airline;
import com.example.system.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Integer> {

    Optional<Flight> findFlightsByAirline(Airline airline);

}
