package com.tp4.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.tp4.models.Foyer;
import com.tp4.models.Universite;
import com.tp4.tp.FoyerRepository;
import com.tp4.tp.UniversiteRepository;

@Controller
@RequestMapping("/universite")
public class UniversiteController {

    @Autowired
    UniversiteRepository universiteRepository;
    @Autowired
    FoyerRepository foyerRepository;

    @RequestMapping("/add")
    @ResponseBody
    public String addUniversite(@RequestParam String nomUniversite, @RequestParam String adresse , @RequestParam Long idF) {
        Foyer foyer = foyerRepository.findById(idF).orElse(null);
        if (foyer == null) {
            foyer = new Foyer(1000);
            foyerRepository.save(foyer);
        }
            Universite universite = new Universite(nomUniversite, adresse, foyer);
            universiteRepository.save(universite);
            return "Universite added";
        
        
    }

    @RequestMapping("/all")
    @ResponseBody
    public Iterable<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }
}

