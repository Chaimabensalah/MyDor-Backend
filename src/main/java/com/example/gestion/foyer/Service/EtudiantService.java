package com.example.gestion.foyer.Service;

import com.example.gestion.foyer.Entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiant();

    Etudiant getEtudiantById(long id);

    Etudiant createEtudiant(Etudiant etudiant);

    Etudiant updateEtudiant(Etudiant etudiant);

    void deleteEtudiant(long id);
}