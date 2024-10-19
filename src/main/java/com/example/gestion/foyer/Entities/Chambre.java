package com.example.gestion.foyer.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChambre ;
    Long numeroChambre ;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;
    @OneToMany()
    Set<Reservation> reservations;
    @ManyToOne
    Bloc bloc;

}
