package com.tp4.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.tp4.tp.Repesetories.BlocRepository;
import com.tp4.tp.Repesetories.FoyerRepository;
import com.tp4.tp.models.Bloc;
import com.tp4.tp.models.Foyer;

@Controller
@RequestMapping("/bloc")
public class BlocController {

    @Autowired
    BlocRepository blocRepository;

    @Autowired
    FoyerRepository foyerRepository;

    @RequestMapping("/add")
    @ResponseBody
    public String addBloc(@RequestParam String nomBloc, @RequestParam Long capaciteBloc, @RequestParam Long idFoyer) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        if (foyer == null) {
            return "Foyer not found";
        }
        Bloc bloc = new Bloc(nomBloc, capaciteBloc, foyer);
        blocRepository.save(bloc);
        return "Bloc added";
    }

    @RequestMapping("/all")
    @ResponseBody
    public Iterable<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }
}
