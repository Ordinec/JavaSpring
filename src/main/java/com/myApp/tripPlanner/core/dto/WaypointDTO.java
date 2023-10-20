package com.myApp.tripPlanner.core.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class WaypointDTO {
    private Long id;
    private String name;
    private String coordinates;
    private TripDTO tripDTO;
}
