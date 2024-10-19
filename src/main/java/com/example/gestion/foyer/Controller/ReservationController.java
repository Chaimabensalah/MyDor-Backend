package com.example.gestion.foyer.Controller;

import com.example.gestion.foyer.Entities.Etudiant;
import com.example.gestion.foyer.Entities.Reservation;
import com.example.gestion.foyer.Service.EtudiantService;
import com.example.gestion.foyer.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Reservation")
@RestController
public class ReservationController {
    private final String NO_DATA_FOUND = "No data found!";
    @Autowired
    ReservationService reservationService;

    @GetMapping
    public ResponseEntity<?> getReservation() {
        List<Reservation> listReservation = reservationService.getAllReservation();
        if (listReservation.isEmpty()) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(listReservation, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Long id) {
        return new ResponseEntity<>(reservationService.getReservationById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationService.createReservation(reservation);
        if (newReservation == null) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(newReservation, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateEtudiant(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setIdReservation(id);
        return new ResponseEntity<>(reservationService.updateReservation(reservation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>("Reservation deleted successfully", HttpStatus.OK);
    }
}
