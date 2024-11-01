package com.example.Prueba_AV.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private  String flight_carrier;

    @Column(nullable = false, length = 50)
    private  String flight_number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlight_carrier() {
        return flight_carrier;
    }

    public void setFlight_carrier(String flight_carrier) {
        this.flight_carrier = flight_carrier;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }
}
