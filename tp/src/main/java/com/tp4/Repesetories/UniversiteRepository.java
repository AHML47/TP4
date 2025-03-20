package com.tp4.Repesetories;



import org.springframework.data.repository.CrudRepository;
import com.tp4.models.Universite;
import org.springframework.stereotype.Repository;
@Repository
public interface UniversiteRepository extends CrudRepository<Universite, Long> {
}
