package com.myApp.tripPlanner.services;

import com.myApp.tripPlanner.core.dto.TripDTO;
import com.myApp.tripPlanner.core.dto.WaypointDTO;

import java.util.List;

public interface TripService {

    List<WaypointDTO> getTripWaypoints(long id);
    String getTripName(long id);
    long getTripId(String name);
    TripDTO add(TripDTO tripDTO);
    void remove(TripDTO tripDTO);
    void remove(long id);
    TripDTO getTrip(long id);

}
