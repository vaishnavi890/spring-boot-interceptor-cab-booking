package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserServiceController {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);

    @Autowired
    private UserService service;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers() {
        logger.info("/user GET invoked");
        return new ResponseEntity<>(service.retrieveUsers(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestParam String name, @RequestParam String email) {
        logger.info("/user POST invoked");
        User user = new User(name, email);
        return new ResponseEntity<>(service.storeUser(user) ? "User added" : "User NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        logger.info("/user DELETE invoked");
        return new ResponseEntity<>(service.deleteUser(id) ? "User deleted" : "User NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> searchUser(@PathVariable int id) {
        logger.info("/user GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}

