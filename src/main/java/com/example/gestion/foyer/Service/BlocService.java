package com.example.gestion.foyer.Service;

import com.example.gestion.foyer.Entities.Bloc;


import java.util.List;

public interface BlocService {
    List<Bloc> getAllbloc();

    Bloc getblocById(Long id);

    Bloc createbloc(Bloc bloc);

    Bloc updatebloc(Bloc bloc);

    void deletebloc(Long id);
}
