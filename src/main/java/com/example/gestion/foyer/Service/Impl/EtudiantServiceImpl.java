package com.example.gestion.foyer.Service.Impl;

import com.example.gestion.foyer.Entities.Bloc;
import com.example.gestion.foyer.Entities.Etudiant;
import com.example.gestion.foyer.Repositories.BlocRepo;
import com.example.gestion.foyer.Repositories.EtudiantrRepo;
import com.example.gestion.foyer.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    EtudiantrRepo etudiantrRepo;
    private final String NO_DATA_FOUND = "No data found!";

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantrRepo.findAll();
    }

    @Override
    public Etudiant getEtudiantById(long id) {
        return etudiantrRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
    }

    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantrRepo.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        Etudiant existingEtudiant = etudiantrRepo.findById(etudiant.getIdEtudiant()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        existingEtudiant.setIdEtudiant(etudiant.getIdEtudiant());
        return etudiantrRepo.save(existingEtudiant);
    }

    @Override
    public void deleteEtudiant(long id) {
        Etudiant etudiant = etudiantrRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        etudiantrRepo.delete(etudiant);

    }
}
