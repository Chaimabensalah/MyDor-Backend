package com.example.gestion.foyer.Service;

import com.example.gestion.foyer.Entities.Foyer;

import java.util.List;

public interface FoyerService {
    List<Foyer> getAllfoyer();

    Foyer getfoyerById(long id);

    Foyer createfoyer(Foyer foyer);

    Foyer updatefoyer(Foyer foyer);

    void deletefoyer(long id);
}


