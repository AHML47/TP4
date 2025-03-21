package com.tp4.tp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonIgnoreProperties({"nomUniversite", "adresse", "foyer"})
    @JoinColumn(name = "universite_id" , referencedColumnName = "idUniversite")
    private Universite universite;



    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonIgnoreProperties({"nomBloc", "capaciteBloc", "foyer","chambres"})
    @JsonManagedReference
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

    public Long getIdFoyer() {
        return idFoyer;
    }

    public void setIdFoyer(Long idFoyer) {
        this.idFoyer = idFoyer;
    }

    public String getNomFoyer() {
        return nomFoyer;
    }

    public void setNomFoyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    public Long getCapaciteFoyer() {
        return capaciteFoyer;
    }

    public void setCapaciteFoyer(Long capaciteFoyer) {
        this.capaciteFoyer = capaciteFoyer;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public List<Bloc> getBlocs() {
        return blocs;
    }

    public void setBlocs(List<Bloc> blocs) {
        this.blocs = blocs;
    }
}
