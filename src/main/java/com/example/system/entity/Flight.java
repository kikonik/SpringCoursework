package com.example.system.entity;
import jakarta.persistence.Entity;
import lombok.Data;
import java.time.LocalDateTime;

@Entity(name = "Flights")
@Data
public class Flight {

    private int flightID;
    private int airlineID;
    private int originAirportID;
    private int destinationAirportID;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}
