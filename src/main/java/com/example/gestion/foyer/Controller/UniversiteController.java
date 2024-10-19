package com.example.gestion.foyer.Controller;

import com.example.gestion.foyer.Entities.Universite;
import com.example.gestion.foyer.Service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Universite")
@RestController
public class UniversiteController {
    private final String NO_DATA_FOUND = "No data found!";
    @Autowired
    UniversiteService universiteService;

    @GetMapping
    public ResponseEntity<?> getUniversite() {
        List<Universite> listUniversite = universiteService.getAllUniversite();
        if (listUniversite.isEmpty()) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(listUniversite, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUniversiteById(@PathVariable Long id) {
        return new ResponseEntity<>(universiteService.getUniversiteById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> createUniversite(@RequestBody Universite universite) {
        Universite newUniversite = universiteService.createUniversite(universite);
        if (newUniversite == null) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(newUniversite, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universite> updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        universite.setIdUniversite(id);
        return new ResponseEntity<>(universiteService.updateUniversite(universite), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
        return new ResponseEntity<>("Universite deleted successfully", HttpStatus.OK);
    }
}
