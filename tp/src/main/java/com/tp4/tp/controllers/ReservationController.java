package com.tp4.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.tp4.tp.Repesetories.ChambreRepository;
import com.tp4.tp.Repesetories.EtudiantRepository;
import com.tp4.tp.Repesetories.ReservationRepository;
import com.tp4.tp.models.Chambre;
import com.tp4.tp.models.Etudiant;
import com.tp4.tp.models.Reservation;

import java.util.Date;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ChambreRepository chambreRepository;

    @Autowired
    EtudiantRepository etudiantRepository;

    @RequestMapping("/add")
    @ResponseBody
    public String addReservation(@RequestParam String idReservation, @RequestParam Date anneeUniversitaire,
                                  @RequestParam boolean estValide, @RequestParam Long idChambre, @RequestParam Long idEtudiant) {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElse(null);
        if (chambre == null || etudiant == null) {
            return "Chambre or Etudiant not found";
        }
        Reservation reservation = new Reservation(idReservation, anneeUniversitaire, estValide, chambre, etudiant);
        reservationRepository.save(reservation);
        return "Reservation added";
    }

    @RequestMapping("/all")
    @ResponseBody
    public Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
