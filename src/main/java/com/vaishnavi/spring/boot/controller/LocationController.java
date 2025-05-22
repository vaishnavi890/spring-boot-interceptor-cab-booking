package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.Location;
import com.vaishnavi.spring.boot.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {
    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService service;

    @GetMapping("/location")
    public ResponseEntity<List<Location>> getLocations() {
        logger.info("/location GET invoked");
        return new ResponseEntity<>(service.retrieveLocations(), HttpStatus.OK);
    }

    @PostMapping("/location")
    public ResponseEntity<String> addLocation(@RequestParam String latitude, @RequestParam String longitude) {
        logger.info("/location POST invoked");
        Location l = new Location(latitude, longitude);
        return new ResponseEntity<>(service.storeLocation(l) ? "Location added" : "Location NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/location/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable int id) {
        logger.info("/location DELETE invoked");
        return new ResponseEntity<>(service.deleteLocation(id) ? "Location deleted" : "Location NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<String> searchLocation(@PathVariable int id) {
        logger.info("/location GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}


