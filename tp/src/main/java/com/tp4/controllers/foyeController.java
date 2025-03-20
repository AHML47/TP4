package com.tp4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp4.models.Foyer;
import com.tp4.models.Universite;
import com.tp4.tp.FoyerRepository;
import com.tp4.tp.UniversiteRepository;

@Controller
@RequestMapping("/foye")
public class foyeController {
    @Autowired
    FoyerRepository foyerRepository;
    @Autowired
    UniversiteRepository universiteRepository;

    @RequestMapping("/add")
    @ResponseBody
    public String addFoyer(@RequestParam String nomFoyer, @RequestParam Long cap , @RequestParam Long idU) {
        Universite universite = universiteRepository.findById(idU).orElse(null);
        Foyer foyer = new Foyer(nomFoyer, cap, universite);
        foyerRepository.save(foyer);
        return "Foyer added";
    }
    
    
}
