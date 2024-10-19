package com.example.gestion.foyer.Service;

import com.example.gestion.foyer.Entities.Chambre;
import com.example.gestion.foyer.Entities.Foyer;

import java.util.List;

public interface ChambreService {
    List<Chambre> getAllchambre();

    Chambre getchambreById(long id);

    Chambre createchambre(Chambre chambre);

    Chambre updatechambre(Chambre chambre);

    void deletechambre(long id);
}
