package com.example.system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "aircraft")
@Data
public class Aircraft {

    @Id
    @GeneratedValue
    private int aircraftId;

    @Column(name = "type")
    private String type;

    @Column(name = "capacity")
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

}
