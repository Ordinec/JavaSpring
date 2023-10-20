package com.myApp.tripPlanner.core.utils;

import com.myApp.tripPlanner.core.dto.WaypointDTO;
import com.myApp.tripPlanner.core.entities.Waypoint;
import org.springframework.stereotype.Component;

@Component
public class WaypointMapper {
    public WaypointDTO toDTO(Waypoint waypoint) {
        WaypointDTO dto = new WaypointDTO();
        dto.setId(waypoint.getId());
        dto.setName(waypoint.getName());
        dto.setCoordinates(waypoint.getCoordinates());
        return dto;
    }

    public Waypoint toEntity(WaypointDTO waypointDTO) {
        Waypoint waypoint = new Waypoint();
        waypoint.setId(waypointDTO.getId());
        waypoint.setName(waypointDTO.getName());
        waypoint.setCoordinates(waypointDTO.getCoordinates());
        return waypoint;
    }
}
