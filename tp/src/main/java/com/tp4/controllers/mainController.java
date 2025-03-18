package com.tp4.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp4.models.Etudiant;
import com.tp4.tp.EtudiantRepository;

@Controller
@RequestMapping("/ejjaw")
public class mainController {
    @Autowired
    EtudiantRepository etudiantRepository;
    
    @RequestMapping("/addstudent")
    @ResponseBody
    public String addStudent(@RequestParam String nomEt,@RequestParam String prenomEt,@RequestParam Long cin,@RequestParam String ecole,@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateNaissance){ 
        etudiantRepository.save(new Etudiant(nomEt, prenomEt, cin, ecole,dateNaissance ));
        return "Student added";
    


    
}
    }
