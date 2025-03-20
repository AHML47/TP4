package com.tp4.tp.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp4.tp.Repesetories.EtudiantRepository;
import com.tp4.tp.models.Etudiant;


@Controller
@RequestMapping("/student")
public class studentController {
     @Autowired
    EtudiantRepository etudiantRepository;
    
    @RequestMapping("/addstudent")
    @ResponseBody
    public String addStudent(@RequestParam String nomEt,@RequestParam String prenomEt,@RequestParam Long cin,@RequestParam String ecole,@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateNaissance){ 
        etudiantRepository.save(new Etudiant(nomEt, prenomEt, cin, ecole,dateNaissance ));
        return "Student added";
    

    }
    @RequestMapping("/getAllstudents")
    @ResponseBody
    public Iterable<Etudiant> getAllStudents(){
        return etudiantRepository.findAll();
    }
    
}
