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

    @RequestMapping("/ride")
    public ResponseEntity<List<Ride>> getRides() {
        logger.info("/rides request invoked");
        return new ResponseEntity<>(service.retrieveRides(), HttpStatus.OK);
    }

    @PostMapping("/ride")
    public ResponseEntity<String> addRide(@RequestParam int userId, @RequestParam int driverId, @RequestParam String pickup, @RequestParam String dropoff) {
        logger.info("/addRide request invoked");
        Ride ride = new Ride(userId, driverId, pickup, dropoff);
        return new ResponseEntity<>(service.storeRide(ride) ? "Ride booked" : "Ride NOT booked", HttpStatus.OK);
    }

    @DeleteMapping("/ride/{id}")
    public ResponseEntity<String> removeRide(@PathVariable int id) {
        logger.info("/removeRide request invoked");
        return new ResponseEntity<>(service.deleteRide(id) ? "Ride removed" : "Ride NOT removed", HttpStatus.OK);
    }

    @GetMapping("/ride/{id}")
    public ResponseEntity<String> searchRide(@PathVariable int id) {
        logger.info("/searchRide request invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}


