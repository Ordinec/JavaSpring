package com.myApp.tripPlanner.controllers;

import com.myApp.tripPlanner.core.dto.WaypointDTO;
import com.myApp.tripPlanner.services.WaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/waypoint")
public class WaypointController {
    private final WaypointService service;

    @Autowired
    public WaypointController(WaypointService service) {
        this.service = service;
    }

    @GetMapping("/getWaypoint")
    public ResponseEntity<WaypointDTO> getUser(@RequestParam("id") long waypointId){
        return ResponseEntity.ok(service.getById(waypointId));
    }

    @PostMapping("/addWaypoint")
    public ResponseEntity<WaypointDTO> addWaypoint(@RequestBody WaypointDTO waypointDTO){
        return ResponseEntity.ok(service.add(waypointDTO));
    }

    @GetMapping("/removeWaypoint")
    public ResponseEntity.BodyBuilder removeUser(@RequestParam("id") long waypointId){
        service.remove(waypointId);
        return ResponseEntity.ok();
    }

    @PostMapping("/removeWaypoint")
    public ResponseEntity.BodyBuilder removeUser(@RequestBody WaypointDTO waypointDTO){
        service.remove(waypointDTO);
        return ResponseEntity.ok();
    }
}
