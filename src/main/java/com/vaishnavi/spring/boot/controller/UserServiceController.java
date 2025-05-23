package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserServiceController {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);

    @Autowired
    private UserService service;

    @RequestMapping(value = "/user")
    public ResponseEntity<List<User>> getUsers() {
        logger.info("/users request got invoked..inside the controller");
        return new ResponseEntity<>(service.retrieveUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<String> addUser(@RequestParam String name, @RequestParam String email, @RequestParam String phone) {
        logger.info("/addUser request got invoked..inside the controller");
        User user = new User(name, email, phone);
        return new ResponseEntity<>(service.storeUser(user) ? "User added to list" : "User NOT added to list", HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<String> removeUser(@PathVariable int id) {
        logger.info("/removeUser request got invoked..inside the controller");
        return new ResponseEntity<>(service.deleteUser(id) ? "User removed from list" : "User NOT removed from list", HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<String> search(@PathVariable int id) {
        logger.info("/searchUser request got invoked..inside the controller");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}
