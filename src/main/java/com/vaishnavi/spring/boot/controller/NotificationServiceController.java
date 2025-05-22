package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.Notification;
import com.vaishnavi.spring.boot.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationServiceController {
    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceController.class);

    @Autowired
    private NotificationService service;

    @GetMapping("/notification")
    public ResponseEntity<List<Notification>> getNotifications() {
        logger.info("/notification GET invoked");
        return new ResponseEntity<>(service.retrieveNotifications(), HttpStatus.OK);
    }

    @PostMapping("/notification")
    public ResponseEntity<String> addNotification(@RequestParam int userId, @RequestParam String message) {
        logger.info("/notification POST invoked");
        Notification n = new Notification(userId, message);
        return new ResponseEntity<>(service.storeNotification(n) ? "Notification added" : "Notification NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/notification/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable int id) {
        logger.info("/notification DELETE invoked");
        return new ResponseEntity<>(service.deleteNotification(id) ? "Notification deleted" : "Notification NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/notification/{id}")
    public ResponseEntity<String> searchNotification(@PathVariable int id) {
        logger.info("/notification GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}



