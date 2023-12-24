package com.example.system.service;

import com.example.system.entity.Airport;
import com.example.system.entity.Flight;
import com.example.system.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
@RequiredArgsConstructor
public class AirportService {
    final AirportRepository airportRepository;

    public Airport createAirport(Airport airport){
        return airportRepository.save(airport);
    }

    public void deleteById(int id){
        airportRepository.deleteById(id);
    }

    public Airport updateFlight(Airport updatedAirportData){
        Airport existingAirport = airportRepository.findById(updatedAirportData.getAirportId()).orElseThrow();

        existingAirport.setFlightsFrom(updatedAirportData.getFlightsFrom());
        existingAirport.setFlightsTo(updatedAirportData.getFlightsTo());
        existingAirport.setAirportName(updatedAirportData.getAirportName());
        existingAirport.setAirportCode(updatedAirportData.getAirportCode());
        existingAirport.setCountry(updatedAirportData.getCountry());
        existingAirport.setCity(updatedAirportData.getCity());

        return airportRepository.save(existingAirport);
    }



}
