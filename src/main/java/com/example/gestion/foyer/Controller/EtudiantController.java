package com.example.gestion.foyer.Controller;

import com.example.gestion.foyer.Entities.Etudiant;
import com.example.gestion.foyer.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Etudiant")
@RestController
public class EtudiantController {
    private final String NO_DATA_FOUND = "No data found!";
    @Autowired
    EtudiantService etudiantService;

    @GetMapping
    public ResponseEntity<?> getEtudiant() {
        List<Etudiant> listEtudiant = etudiantService.getAllEtudiant();
        if (listEtudiant.isEmpty()) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(listEtudiant, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEtudiantById(@PathVariable Long id) {
        return new ResponseEntity<>(etudiantService.getEtudiantById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant newEtudiant = etudiantService.createEtudiant(etudiant);
        if (newEtudiant == null) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(newEtudiant, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        etudiant.setIdEtudiant(id);
        return new ResponseEntity<>(etudiantService.updateEtudiant(etudiant), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>("Etudiant deleted successfully", HttpStatus.OK);
    }
}
