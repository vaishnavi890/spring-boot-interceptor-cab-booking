package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository repo = new UserRepository();

    public List<User> getAllUsers() {
        logger.info("Inside UserService.getAllUsers()");
        return repo.findAll();
    }

    public boolean registerUser(User user) {
        logger.info("Inside UserService.registerUser()");
        return repo.save(user);
    }

    public boolean deleteUser(int userId) {
        logger.info("Inside UserService.deleteUser()");
        return repo.delete(userId);
    }

    public User getUserById(int userId) {
        logger.info("Inside UserService.getUserById()");
        return repo.findById(userId);
    }

    public boolean updateUser(User user) {
        logger.info("Inside UserService.updateUser()");
        return repo.update(user);
    }

    public List<User> retrieveUsers() {
        return List.of();
    }

    public boolean storeUser(User user) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}


