package com.example.Prueba_AV.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "journey_flights")
public class JourneyFlights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "journey_id")
    private Journey journey_id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight_id;

    public Journey getJourney_id() {
        return journey_id;
    }

    public void setJourney_id(Journey journey_id) {
        this.journey_id = journey_id;
    }

    public Flight getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Flight flight_id) {
        this.flight_id = flight_id;
    }
}
