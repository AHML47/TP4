package com.tp4.tp.Repesetories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tp4.tp.models.Bloc;
@Repository
public interface BlocRepository extends CrudRepository<Bloc, Long> {
}
