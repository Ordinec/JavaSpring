package com.myApp.tripPlanner.services;

import com.myApp.tripPlanner.core.entities.User;

public interface UserService {
    User getById(String id);

    User add(User user);

    void remove(User user);

    void remove(int id);

    void update(int id, User user);
}
