package com.example.gestion.foyer.Controller;

import com.example.gestion.foyer.Entities.Bloc;
import com.example.gestion.foyer.Service.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Bloc")
@RestController
public class BlocController {
    private final String NO_DATA_FOUND = "No data found!";
    @Autowired
    BlocService blocService;

    @GetMapping
    public ResponseEntity<?> getBloc() {
        List<Bloc> listBloc = blocService.getAllbloc();
        if (listBloc.isEmpty()) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(listBloc, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlocById(@PathVariable Long id) {
        return new ResponseEntity<>(blocService.getblocById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> createBloc(@RequestBody Bloc bloc) {
        Bloc newBloc = blocService.createbloc(bloc);
        if (newBloc == null) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(newBloc, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        bloc.setIdBloc(id);
        return new ResponseEntity<>(blocService.updatebloc(bloc), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBloc(@PathVariable Long id) {
        blocService.deletebloc(id);
        return new ResponseEntity<>("Bloc deleted successfully", HttpStatus.OK);
    }
}
