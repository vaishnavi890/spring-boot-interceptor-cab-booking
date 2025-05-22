package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.Driver;
import com.vaishnavi.spring.boot.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverServiceController {
    private static final Logger logger = LoggerFactory.getLogger(DriverServiceController.class);

    @Autowired
    private DriverService service;

    @GetMapping("/driver")
    public ResponseEntity<List<Driver>> getDrivers() {
        logger.info("/driver GET invoked");
        return new ResponseEntity<>(service.retrieveDrivers(), HttpStatus.OK);
    }

    @PostMapping("/driver")
    public ResponseEntity<String> addDriver(@RequestParam String name, @RequestParam String license) {
        logger.info("/driver POST invoked");
        Driver driver = new Driver(name, license);
        return new ResponseEntity<>(service.storeDriver(driver) ? "Driver added" : "Driver NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/driver/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable int id) {
        logger.info("/driver DELETE invoked");
        return new ResponseEntity<>(service.deleteDriver(id) ? "Driver deleted" : "Driver NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<String> searchDriver(@PathVariable int id) {
        logger.info("/driver GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}



