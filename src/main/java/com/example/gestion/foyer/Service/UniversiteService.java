package com.example.gestion.foyer.Service;


import com.example.gestion.foyer.Entities.Universite;

import java.util.List;

public interface UniversiteService {
    List<Universite> getAllUniversite();

    Universite getUniversiteById(long id);

    Universite createUniversite(Universite universite);

    Universite updateUniversite(Universite universite);

    void deleteUniversite(long id);
}
