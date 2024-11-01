package com.example.Prueba_AV.Controller;

import com.example.Prueba_AV.Model.JourneyFlights;
import com.example.Prueba_AV.Model.JourneySearchDTO;
import com.example.Prueba_AV.Model.JourneyWithFlightsDTO;
import com.example.Prueba_AV.Service.JourneyFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/API/journeyFlights")
public class JourneyFlightsController {

    @Autowired
    private JourneyFlightsService journeyFlightsService;

    @GetMapping
    public ResponseEntity<List<JourneyFlights>> getAllJourneyFlights(){
        try {
            List<JourneyFlights> journeyFlights = journeyFlightsService.getAllJourneyFlights();
            return ResponseEntity.ok(journeyFlights);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<JourneyFlights> getJourneyFlightsById(@PathVariable Long id) {
        try {
            JourneyFlights journeyFlights = journeyFlightsService.getJourneyFlightsById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Journey-Flights no encontrado"));
            return ResponseEntity.ok(journeyFlights);
        }catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/journeyWithFlights/{id}")
    public ResponseEntity<JourneyWithFlightsDTO> getJourneyWithFlights(@PathVariable Long id) {
        try {
            JourneyWithFlightsDTO journeyWithFlights = journeyFlightsService.getJourneyWithFlights(id);
            return ResponseEntity.ok(journeyWithFlights);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/search")
    public ResponseEntity<List<JourneyWithFlightsDTO>> searchJourneyWithFlights(@RequestBody JourneySearchDTO searchDTO) {
        List<JourneyWithFlightsDTO> journeyWithFlights = journeyFlightsService.searchJourneyWithFlights(searchDTO);
        return ResponseEntity.ok(journeyWithFlights);
    }
}
