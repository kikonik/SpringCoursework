package com.example.system.service;

import com.example.system.entity.Flight;
import com.example.system.repository.FlightsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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


   public Flight updateFlight(int id, Flight updatedFlightData){
      Flight existingFlight = flightsRepository.findById(id).orElse(null);

      if (existingFlight == null){
         return null;
      }

      existingFlight.setAirline(updatedFlightData.getAirline());
      existingFlight.setOriginAirport(updatedFlightData.getOriginAirport());
      existingFlight.setDestinationAirport(updatedFlightData.getDestinationAirport());
      existingFlight.setDepartureTime(updatedFlightData.getDepartureTime());
      existingFlight.setArrivalTime(updatedFlightData.getArrivalTime());

      return flightsRepository.save(existingFlight);
   }

}
