package com.example.gestion.foyer.Repositories;


import com.example.gestion.foyer.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo  extends JpaRepository<Reservation, Long> {
}
