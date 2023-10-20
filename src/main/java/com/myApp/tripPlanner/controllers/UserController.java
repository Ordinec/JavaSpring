package com.myApp.tripPlanner.controllers;

import com.myApp.tripPlanner.core.entities.User;
import com.myApp.tripPlanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam("id") String userId){
        return ResponseEntity.ok(service.getById(userId));
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(service.add(user));
    }

    @GetMapping("/removeUser")
    public ResponseEntity.BodyBuilder removeUser(@RequestParam("id") int userId){
        service.remove(userId);
        return ResponseEntity.ok();
    }

    @PostMapping("/removeUser")
    public ResponseEntity.BodyBuilder removeUser(@RequestBody User user){
        service.remove(user);
        return ResponseEntity.ok();
    }

    @PostMapping("/updateUser")
    public ResponseEntity.BodyBuilder updateUser(@RequestBody int id, User user){
        service.update(id, user);
        return ResponseEntity.ok();
    }
}
