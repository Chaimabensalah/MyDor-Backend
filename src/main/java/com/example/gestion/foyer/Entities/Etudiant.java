package com.example.gestion.foyer.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEtudiant ;
    String nomEt ;
    String prenomEt ;
    String cin;
    String ecole;
    Date dateNaissance = new Date();
    @ManyToMany(mappedBy = "etudiants", cascade = CascadeType.ALL)
    private  Set<Reservation> reservations;
}
