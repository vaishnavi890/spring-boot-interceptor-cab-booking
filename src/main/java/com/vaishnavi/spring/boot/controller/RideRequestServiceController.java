package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.RideRequest;
import com.vaishnavi.spring.boot.service.RideRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RideRequestServiceController {
    private static final Logger logger = LoggerFactory.getLogger(RideRequestServiceController.class);

    @Autowired
    private RideRequestService service;

    @GetMapping("/riderequest")
    public ResponseEntity<List<RideRequest>> getRideRequests() {
        logger.info("/riderequest GET invoked");
        return new ResponseEntity<>(service.retrieveRideRequests(), HttpStatus.OK);
    }

    @PostMapping("/riderequest")
    public ResponseEntity<String> addRideRequest(@RequestParam int userId, @RequestParam String from, @RequestParam String to) {
        logger.info("/riderequest POST invoked");
        RideRequest req = new RideRequest(userId, from, to);
        return new ResponseEntity<>(service.storeRideRequest(req) ? "RideRequest added" : "RideRequest NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/riderequest/{id}")
    public ResponseEntity<String> deleteRideRequest(@PathVariable int id) {
        logger.info("/riderequest DELETE invoked");
        return new ResponseEntity<>(service.deleteRideRequest(id) ? "RideRequest deleted" : "RideRequest NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/riderequest/{id}")
    public ResponseEntity<String> searchRideRequest(@PathVariable int id) {
        logger.info("/riderequest GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}


