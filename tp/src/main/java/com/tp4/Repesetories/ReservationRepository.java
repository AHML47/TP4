package com.tp4.Repesetories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tp4.models.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, String> {
}
