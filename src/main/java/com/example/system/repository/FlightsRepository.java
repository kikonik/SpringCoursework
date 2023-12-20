package com.example.system.repository;

import com.example.system.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Integer> {

}
