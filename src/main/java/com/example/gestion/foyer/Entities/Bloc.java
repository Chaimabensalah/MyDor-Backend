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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBloc ;
    String nomBloc ;
    Long CapaciteBloc ;
    @ManyToOne
    Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    Set<Chambre> chambres;



}
