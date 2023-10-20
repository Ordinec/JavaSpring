package com.myApp.tripPlanner.services;

import com.myApp.tripPlanner.core.dto.WaypointDTO;

public interface WaypointService {
    WaypointDTO add(WaypointDTO waypointDTO);
    WaypointDTO getById(long id);

    void remove(WaypointDTO waypointDTO);
    void remove(long id);
}
