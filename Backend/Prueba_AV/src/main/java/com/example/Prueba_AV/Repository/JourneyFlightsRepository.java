package com.example.Prueba_AV.Repository;

import com.example.Prueba_AV.Model.JourneyFlights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JourneyFlightsRepository extends JpaRepository<JourneyFlights, Long> {

    @Query("SELECT jf FROM JourneyFlights jf WHERE jf.journey_id.id = :journeyId")
    List<JourneyFlights> findByJourneyId(@Param("journeyId") Long journeyId);

}
