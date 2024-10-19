package com.example.gestion.foyer.Repositories;

import com.example.gestion.foyer.Entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoyerRepo extends JpaRepository<Foyer, Long> {
}
