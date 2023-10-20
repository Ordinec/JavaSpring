package com.myApp.tripPlanner.core.dto;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class TripDTO implements Serializable {
    private Long id;
    private String name;
    private List<WaypointDTO> waypoints = new ArrayList<>();
}
