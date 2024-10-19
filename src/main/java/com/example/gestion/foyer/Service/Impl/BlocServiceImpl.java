package com.example.gestion.foyer.Service.Impl;

import com.example.gestion.foyer.Entities.Bloc;
import com.example.gestion.foyer.Repositories.BlocRepo;
import com.example.gestion.foyer.Service.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BlocServiceImpl implements BlocService {
    @Autowired
    BlocRepo blocRepo;
    private final String NO_DATA_FOUND = "No data found!";


    @Override
    public List<Bloc> getAllbloc() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc getblocById(Long id) {
        return blocRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));

    }

    @Override
    public Bloc createbloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc updatebloc(Bloc bloc) {
        Bloc existingbloc = blocRepo.findById(bloc.getIdBloc()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        existingbloc.setIdBloc(bloc.getIdBloc());
        return blocRepo.save(existingbloc);
    }

    @Override
    public void deletebloc(Long id) {
        Bloc bloc = blocRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NO_DATA_FOUND));
        blocRepo.delete(bloc);
    }
}
