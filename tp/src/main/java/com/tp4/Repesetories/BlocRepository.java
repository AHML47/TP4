package com.tp4.Repesetories;

import org.springframework.data.repository.CrudRepository;


import com.tp4.models.Bloc;
import org.springframework.stereotype.Repository;
@Repository
public interface BlocRepository extends CrudRepository<Bloc, Long> {
}
