package com.myApp.tripPlanner.controllers;

import com.myApp.tripPlanner.core.dto.TripDTO;
import com.myApp.tripPlanner.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trip")
public class TripController {
    private final TripService service;

    @Autowired
    public TripController(TripService service) {
        this.service = service;
    }

    @GetMapping("/getTrip")
    public ResponseEntity<TripDTO> getTrip(@RequestParam("id") long tripId){
        return ResponseEntity.ok(service.getTrip(tripId));
    }

    @PostMapping("/addTrip")
    public ResponseEntity<TripDTO> addTrip(@RequestBody TripDTO tripDTO){
        return ResponseEntity.ok(service.add(tripDTO));
    }

    @GetMapping("/removeTrip")
    public ResponseEntity.BodyBuilder removeUser(@RequestParam("id") long tripId){
        service.remove(tripId);
        return ResponseEntity.ok();
    }

    @PostMapping("/removeTrip")
    public ResponseEntity.BodyBuilder removeUser(@RequestBody TripDTO tripDTO){
        service.remove(tripDTO);
        return ResponseEntity.ok();
    }
}
