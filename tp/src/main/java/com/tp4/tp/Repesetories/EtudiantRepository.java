package com.tp4.tp.Repesetories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tp4.tp.models.Etudiant;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {
}
