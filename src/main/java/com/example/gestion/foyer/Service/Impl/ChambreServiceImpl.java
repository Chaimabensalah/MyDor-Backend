package com.example.gestion.foyer.Service.Impl;

import com.example.gestion.foyer.Entities.Bloc;
import com.example.gestion.foyer.Entities.Chambre;
import com.example.gestion.foyer.Repositories.ChambreRepo;
import com.example.gestion.foyer.Service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ChambreServiceImpl implements ChambreService {
    @Autowired
    ChambreRepo chambreRepo;
    private final String NO_DATA_FOUND = "No data found!";

    @Override
    public List<Chambre> getAllchambre() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre getchambreById(long id) {
        return chambreRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));

    }

    @Override
    public Chambre createchambre(Chambre chambre) {
        return chambreRepo.save(chambre);
    }

    @Override
    public Chambre updatechambre(Chambre chambre) {
        Chambre existingchambre = chambreRepo.findById(chambre.getIdChambre()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        existingchambre.setIdChambre(chambre.getIdChambre());
        return chambreRepo.save(existingchambre);
    }

    @Override
    public void deletechambre(long id) {
        Chambre chambre = chambreRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        chambreRepo.delete(chambre);

    }
}
