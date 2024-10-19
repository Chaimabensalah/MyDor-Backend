package com.example.gestion.foyer.Repositories;

import com.example.gestion.foyer.Entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepo extends JpaRepository<Chambre, Long> {
}
