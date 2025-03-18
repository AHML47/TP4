package com.tp4.models;

import java.util.Date;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    private String idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    public Reservation() {
    }
    public Reservation(String idReservation, Date anneeUniversitaire, boolean estValide, Chambre chambre, Etudiant etudiant) {
        this.idReservation = idReservation;
        this.anneeUniversitaire = anneeUniversitaire;
        this.estValide = estValide;
        this.chambre = chambre;
        this.etudiant = etudiant;
    }
}
