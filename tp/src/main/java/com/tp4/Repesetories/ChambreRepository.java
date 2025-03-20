package com.tp4.Repesetories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tp4.models.Chambre;

@Repository
public interface ChambreRepository extends CrudRepository<Chambre, Long> {
}
