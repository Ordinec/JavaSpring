package com.myApp.tripPlanner.core.repository;

import com.myApp.tripPlanner.core.entities.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
    Trip findById(long id);
    Trip findByName(String name);
}
