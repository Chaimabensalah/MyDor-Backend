package com.example.gestion.foyer.Service.Impl;

import com.example.gestion.foyer.Entities.Bloc;
import com.example.gestion.foyer.Entities.Foyer;
import com.example.gestion.foyer.Repositories.FoyerRepo;
import com.example.gestion.foyer.Service.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FoyerServiceImpl implements FoyerService {
    @Autowired
    FoyerRepo foyerRepo;
    private final String NO_DATA_FOUND = "No data found!";

    @Override
    public List<Foyer> getAllfoyer() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer getfoyerById(long id) {
        return foyerRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));

    }

    @Override
    public Foyer createfoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }

    @Override
    public Foyer updatefoyer(Foyer foyer) {
        Foyer existingfoyer = foyerRepo.findById(foyer.getIdFoyer()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        existingfoyer.setIdFoyer(foyer.getIdFoyer());
        return foyerRepo.save(existingfoyer);
    }

    @Override
    public void deletefoyer(long id) {
        Foyer foyer = foyerRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        foyerRepo.delete(foyer);
    }
}
