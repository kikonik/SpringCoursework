package com.example.system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name = "airline")
@Data
public class Airline {

    @Id
    @GeneratedValue
    @Column(name = "airline_id")
    private int airlineId;

    @Column(name = "airline_name")
    private String airlineName;

    @Column(name = "airline_code")
    private String airlineCode;

    @OneToMany(mappedBy = "airline")
    private Set<Flight> flights;

    @OneToMany(mappedBy = "airline")
    private Set<Aircraft> aircraft;

}
