package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.Ride;
import com.vaishnavi.spring.boot.service.RideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RideServiceController {
    private static final Logger logger = LoggerFactory.getLogger(RideServiceController.class);

    @Autowired
    private RideService service;

    @GetMapping("/ride")
    public ResponseEntity<List<Ride>> getRides() {
        logger.info("/ride GET invoked");
        return new ResponseEntity<>(service.retrieveRides(), HttpStatus.OK);
    }

    @PostMapping("/ride")
    public ResponseEntity<String> addRide(@RequestParam int userId, @RequestParam int driverId,
                                          @RequestParam String pickup, @RequestParam String dropoff,
                                          @RequestParam double fare) {
        logger.info("/ride POST invoked");
        Ride ride = new Ride(userId, driverId, pickup, dropoff, fare);
        return new ResponseEntity<>(service.storeRide(ride) ? "Ride added" : "Ride NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/ride/{id}")
    public ResponseEntity<String> deleteRide(@PathVariable int id) {
        logger.info("/ride DELETE invoked");
        return new ResponseEntity<>(service.deleteRide(id) ? "Ride deleted" : "Ride NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/ride/{id}")
    public ResponseEntity<String> searchRide(@PathVariable int id) {
        logger.info("/ride GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}


