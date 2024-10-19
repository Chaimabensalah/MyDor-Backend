package com.example.gestion.foyer.Controller;

import com.example.gestion.foyer.Entities.Chambre;
import com.example.gestion.foyer.Service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Chambre")
@RestController
public class ChambreController {
    private final String NO_DATA_FOUND = "No data found!";
    @Autowired
    ChambreService chambreService;

    @GetMapping
    public ResponseEntity<?> getChambre() {
        List<Chambre> listChambre = chambreService.getAllchambre();
        if (listChambre.isEmpty()) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(listChambre, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFoyerById(@PathVariable Long id) {
        return new ResponseEntity<>(chambreService.getchambreById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> createFoyer(@RequestBody Chambre chambre) {
        Chambre newChambre = chambreService.createchambre(chambre);
        if (newChambre == null) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(newChambre, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable Long id, @RequestBody Chambre chambre) {
        chambre.setIdChambre(id);
        return new ResponseEntity<>(chambreService.updatechambre(chambre), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChambre(@PathVariable Long id) {
        chambreService.deletechambre(id);
        return new ResponseEntity<>("chambre deleted successfully", HttpStatus.OK);
    }
}
