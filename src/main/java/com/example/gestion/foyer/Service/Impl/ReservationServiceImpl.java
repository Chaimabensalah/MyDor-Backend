package com.example.gestion.foyer.Service.Impl;

import com.example.gestion.foyer.Entities.Bloc;
import com.example.gestion.foyer.Entities.Reservation;
import com.example.gestion.foyer.Repositories.BlocRepo;
import com.example.gestion.foyer.Repositories.ReservationRepo;
import com.example.gestion.foyer.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepo reservationRepo;
    private final String NO_DATA_FOUND = "No data found!";

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation getReservationById(long id) {
        return reservationRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation existingreservation = reservationRepo.findById(reservation.getIdReservation()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        existingreservation.setIdReservation(reservation.getIdReservation());
        return reservationRepo.save(existingreservation);
    }

    @Override
    public void deleteReservation(long id) {
        Reservation reservation = reservationRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        reservationRepo.delete(reservation);
    }
}
