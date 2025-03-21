package com.tp4.tp.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    @JsonIgnoreProperties({"numeroChambre", "typeC", "bloc","reservations"})
    private Chambre chambre;

    @ManyToOne
    @JsonIgnoreProperties({"nomEt", "prenomEt", "cin","ecole","dateNaissance","reservations"})
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    public Reservation() {
    }
    public Reservation( Date anneeUniversitaire, boolean estValide, Chambre chambre, Etudiant etudiant) {
        
        this.anneeUniversitaire = anneeUniversitaire;
        this.estValide = estValide;
        this.chambre = chambre;
        this.etudiant = etudiant;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Date getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(Date anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public boolean isEstValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
