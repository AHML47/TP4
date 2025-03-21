package com.tp4.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.tp4.tp.Repesetories.BlocRepository;
import com.tp4.tp.Repesetories.ChambreRepository;
import com.tp4.tp.models.Bloc;
import com.tp4.tp.models.Chambre;
import com.tp4.tp.models.TypeChambre;

@Controller
@RequestMapping("/chambre")
public class ChambreController {

    @Autowired
    ChambreRepository chambreRepository;

    @Autowired
    BlocRepository blocRepository;

    @RequestMapping("/add")
    @ResponseBody
    public String addChambre(@RequestParam String numeroChambre, @RequestParam String typeC, @RequestParam Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        if (bloc == null) {
            return "Bloc not found";
        }
        TypeChambre typeChambre = TypeChambre.valueOf(typeC.toUpperCase());
        Chambre chambre = new Chambre(numeroChambre, typeChambre, bloc);
        chambreRepository.save(chambre);
        return "Chambre added";
    }

    @RequestMapping("/all")
    @ResponseBody
    public Iterable<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }
}
