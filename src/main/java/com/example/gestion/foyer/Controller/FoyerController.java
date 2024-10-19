package com.example.gestion.foyer.Controller;

import com.example.gestion.foyer.Entities.Foyer;
import com.example.gestion.foyer.Service.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Foyer")
@RestController
public class FoyerController {
    private final String NO_DATA_FOUND = "No data found!";
    @Autowired
    FoyerService foyerService;

    @GetMapping
    public ResponseEntity<?> getFoyer() {
        List<Foyer> listfoyres = foyerService.getAllfoyer();
        if (listfoyres.isEmpty()) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(listfoyres, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFoyerById(@PathVariable Long id) {
        return new ResponseEntity<>(foyerService.getfoyerById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> createFoyer(@RequestBody Foyer foyer) {
        Foyer newFoyer = foyerService.createfoyer(foyer);
        if (newFoyer == null) {
            return new ResponseEntity<>(NO_DATA_FOUND, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(newFoyer, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foyer> updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer) {
        foyer.setIdFoyer(id);
        return new ResponseEntity<>(foyerService.updatefoyer(foyer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoyer(@PathVariable Long id) {
        foyerService.deletefoyer(id);
        return new ResponseEntity<>("foyer deleted successfully", HttpStatus.OK);
    }
}
