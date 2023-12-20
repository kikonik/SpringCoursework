package com.example.system.service;

import com.example.system.entity.Airline;
import com.example.system.entity.Flight;
import com.example.system.repository.FlightsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.util.HashSet;
import java.util.Set;

@Service
@Component
@RequiredArgsConstructor
public class FlightService {
   final FlightsRepository flightsRepository;

   public Flight createFlight(Flight flight){
         return flightsRepository.save(flight);
   }

   public Set<Flight> getAllFlights(){
      return new HashSet<>(flightsRepository.findAll());
   }

   public void deleteById(int id){
      flightsRepository.deleteById(id);
   }


   public Flight updateFlight(Flight updatedFlightData){
      Flight existingFlight = flightsRepository.findById(updatedFlightData.getFlightId()).orElseThrow();

      existingFlight.setAirline(updatedFlightData.getAirline());
      existingFlight.setOriginAirport(updatedFlightData.getOriginAirport());
      existingFlight.setDestinationAirport(updatedFlightData.getDestinationAirport());
      existingFlight.setDepartureTime(updatedFlightData.getDepartureTime());
      existingFlight.setArrivalTime(updatedFlightData.getArrivalTime());

      return flightsRepository.save(existingFlight);
   }

   public Flight getFlightsByAirline(Airline airline){
      return flightsRepository.findFlightsByAirline(airline).orElseThrow();
   }

}
