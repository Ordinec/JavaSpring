package com.myApp.tripPlanner.core.repository;

import com.myApp.tripPlanner.core.entities.Waypoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaypointRepository extends CrudRepository<Waypoint, Long> {
    Waypoint findById(long id);
}
