package com.example.Prueba_AV.Repository;

import com.example.Prueba_AV.Model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JourneyRepository extends JpaRepository<Journey, Long> {
    List<Journey> findByOriginAndDestination(String origin, String destination);
}
