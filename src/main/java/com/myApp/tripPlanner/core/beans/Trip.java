package com.myApp.tripPlanner.core.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
@Setter
public class Trip {
    private int id;
    private String name;
    private Waypoint[] waypoints;
}
