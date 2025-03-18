package com.tp4.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "bloc")
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL)
    private List<Chambre> chambres;

    public Bloc() {
    }
    public Bloc(String nomBloc, Long capaciteBloc, Foyer foyer) {
        this.nomBloc = nomBloc;
        this.capaciteBloc = capaciteBloc;
        this.foyer = foyer;
    }

}
