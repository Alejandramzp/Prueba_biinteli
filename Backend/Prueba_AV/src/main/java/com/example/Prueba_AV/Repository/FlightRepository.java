package com.example.Prueba_AV.Repository;

import com.example.Prueba_AV.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
