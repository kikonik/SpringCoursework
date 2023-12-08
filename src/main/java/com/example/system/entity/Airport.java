package com.example.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity(name = "airport")
@Data
public class Airport {

    @Id
    @GeneratedValue
    @Column(name = "airport_id")
    private int airportId;

    @OneToMany(mappedBy = "originAirport")
    private Set<Flight> flightsFrom;

    @OneToMany(mappedBy = "destinationAirport")
    private Set<Flight> flightsTo;

    @Column(name = "airport_name")
    private String airportName;

    @Column(name = "airport_code")
    private String airportCode;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;



}
