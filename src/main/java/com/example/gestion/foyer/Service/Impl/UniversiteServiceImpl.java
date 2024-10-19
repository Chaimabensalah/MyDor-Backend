package com.example.gestion.foyer.Service.Impl;

import com.example.gestion.foyer.Entities.Bloc;
import com.example.gestion.foyer.Entities.Universite;
import com.example.gestion.foyer.Repositories.BlocRepo;
import com.example.gestion.foyer.Repositories.UniversiteRepo;
import com.example.gestion.foyer.Service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UniversiteServiceImpl implements UniversiteService {
    @Autowired
    UniversiteRepo universiteRepo;
    private final String NO_DATA_FOUND = "No data found!";

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite getUniversiteById(long id) {
        return universiteRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
    }

    @Override
    public Universite createUniversite(Universite universite) {
        return universiteRepo.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        Universite existingUniversite = universiteRepo.findById(universite.getIdUniversite()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        existingUniversite.setIdUniversite(universite.getIdUniversite());
        return universiteRepo.save(existingUniversite);
    }

    @Override
    public void deleteUniversite(long id) {
        Universite universite = universiteRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        universiteRepo.delete(universite);
    }
}
