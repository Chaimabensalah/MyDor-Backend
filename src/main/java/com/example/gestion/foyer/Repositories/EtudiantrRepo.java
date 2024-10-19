package com.example.gestion.foyer.Repositories;

import com.example.gestion.foyer.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantrRepo extends JpaRepository<Etudiant, Long> {
}
