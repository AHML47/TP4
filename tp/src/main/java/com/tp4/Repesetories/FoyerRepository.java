package com.tp4.Repesetories;


import org.springframework.data.repository.CrudRepository;
import com.tp4.models.Foyer;
import org.springframework.stereotype.Repository;
@Repository
public interface FoyerRepository extends CrudRepository<Foyer, Long> {
}
