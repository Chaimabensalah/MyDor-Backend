package com.example.gestion.foyer.Service;


import com.example.gestion.foyer.Entities.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservation();

    Reservation getReservationById(long id);

    Reservation createReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(long id);
}
