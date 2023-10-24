package com.myApp.tripPlanner.core.utils;

import com.myApp.tripPlanner.core.dto.TripDTO;
import com.myApp.tripPlanner.core.dto.WaypointDTO;
import com.myApp.tripPlanner.core.entities.Trip;
import com.myApp.tripPlanner.core.entities.Waypoint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TripMapper {
    public TripDTO toDTO(Trip trip) {
        TripDTO dto = new TripDTO();
        dto.setId(trip.getId());
        dto.setName(trip.getName());
        dto.setWaypoints(convertWaypointsToDTO(trip.getWaypoints()));
        return dto;
    }

    public Trip toEntity(TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setId(tripDTO.getId());
        trip.setName(tripDTO.getName());
        trip.setWaypoints(convertWaypointsFromDTO(tripDTO.getWaypoints()));
        return trip;
    }

    private List<WaypointDTO> convertWaypointsToDTO(List<Waypoint> waypoints) {
        List<WaypointDTO> result = null;
        WaypointMapper waypointMapper = new WaypointMapper();
        for(Waypoint waypoint : waypoints){
            result.add(waypointMapper.toDTO(waypoint));
        }
        return result;
    }

    private List<Waypoint> convertWaypointsFromDTO(List<WaypointDTO> waypoints) {
        List<Waypoint> result = null;
        WaypointMapper waypointMapper = new WaypointMapper();
        for(WaypointDTO waypoint : waypoints){
            result.add(waypointMapper.toEntity(waypoint));
        }
        return result;
    }
}
