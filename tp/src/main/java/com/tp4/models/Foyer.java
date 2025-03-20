package com.tp4.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "foyer")
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    @OneToOne
    @JoinColumn(name = "universite_id" , referencedColumnName = "idUniversite")
    private Universite universite;

    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Bloc> blocs;

    public Foyer() {
    }
    public Foyer(int x){
        this.idFoyer = (long) x;
        this.nomFoyer = "pas de foyer";
        this.capaciteFoyer = (long) 0;
    }
    public Foyer(String nomFoyer, Long capaciteFoyer, Universite universite) {
        this.nomFoyer = nomFoyer;
        this.capaciteFoyer = capaciteFoyer;
        this.universite = universite;
    }

}
