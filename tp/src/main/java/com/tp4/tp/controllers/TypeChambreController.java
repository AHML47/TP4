package com.tp4.tp.controllers;

import org.springframework.web.bind.annotation.*;

import com.tp4.tp.models.TypeChambre;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/typeChambre")
public class TypeChambreController {

    @GetMapping("/all")
    public List<TypeChambre> getAllTypes() {
        return Arrays.asList(TypeChambre.values());
    }
}
