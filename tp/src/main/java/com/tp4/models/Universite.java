package com.tp4.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "universite")
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;
    @OneToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

    public Universite() {
    }
    public Universite(String nomUniversite, String adresse, Foyer foyer) {
        this.nomUniversite = nomUniversite;
        this.adresse = adresse;
        this.foyer = foyer;
    }

}