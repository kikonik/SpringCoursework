package com.example.system.controller;


import com.example.system.entity.Airline;
import com.example.system.entity.Airport;
import com.example.system.entity.Flight;
import com.example.system.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("flights")
@RequiredArgsConstructor
public class FlightsController {

    private final FlightService flightService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = CREATED)
    public Flight createFlight(@RequestBody final Flight flight){
        return flightService.createFlight(flight);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flight updateFlight(@RequestBody final Flight flight){
        return flightService.updateFlight(flight);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlight(@PathVariable int id) {
        flightService.deleteById(id);
    }

    @GetMapping(value = "{airline}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flight getFlightsByAirline(@PathVariable Airline airline) {
        return flightService.getFlightsByAirline(airline);
    }

}
