package com.myApp.tripPlanner.services;

import com.myApp.tripPlanner.core.entities.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> usersPool = new LinkedList<>();

    @Override
    public User getById(String id) {
        return usersPool.stream().filter(x -> x.getId().equals(id)).toList().get(0);
    }

    @Transactional
    @Override
    public User add(User user) {
        usersPool.add(user);
        return user;
    }

    @Transactional
    @Override
    public void remove(User user) {
        usersPool.remove(user);
    }

    @Transactional
    @Override
    public void remove(int id) {
        User userToRemove = usersPool.stream().filter(x -> x.getId().equals(id)).toList().get(0);
        usersPool.remove(userToRemove);
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        User userToUpdate = usersPool.stream().filter(x -> x.getId().equals(id)).toList().get(0);
        updateUser(userToUpdate, user);
    }

    @Transactional
    @PostConstruct
    public void init() {
        User user1 = User.builder()
                .name("TestUser")
                .email("test1@test.com")
                .build();

        User user2 = User.builder()
                .name("TestUser2")
                .email("test2@test.com")
                .build();

        User user3 = User.builder()
                .name("TestUser3")
                .email("test3@test.com")
                .build();

        usersPool.addAll(List.of(user1, user2, user3));
    }

    @Transactional
    private void updateUser(User userToUpdate, User newUserData){
        if(!userToUpdate.getName().equals(newUserData.getName())){
            userToUpdate.setName(newUserData.getName());
        } else if(!userToUpdate.getEmail().equals(newUserData.getEmail())){
            userToUpdate.setEmail(newUserData.getEmail());
        }else if(!userToUpdate.getId().equals(newUserData.getId())){
            userToUpdate.setId(newUserData.getId());
        }
    }
}
