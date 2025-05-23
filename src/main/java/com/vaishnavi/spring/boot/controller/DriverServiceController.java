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

    @RequestMapping("/driver")
    public ResponseEntity<List<Driver>> getDrivers() {
        logger.info("/drivers request invoked");
        return new ResponseEntity<>(service.retrieveDrivers(), HttpStatus.OK);
    }

    @PostMapping("/driver")
    public ResponseEntity<String> addDriver(@RequestParam String name, @RequestParam String email, @RequestParam String phone) {
        logger.info("/addDriver request invoked");
        Driver driver = new Driver(name, email, phone);
        return new ResponseEntity<>(service.storeDriver(driver) ? "Driver added" : "Driver NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/driver/{id}")
    public ResponseEntity<String> removeDriver(@PathVariable int id) {
        logger.info("/removeDriver request invoked");
        return new ResponseEntity<>(service.deleteDriver(id) ? "Driver removed" : "Driver NOT removed", HttpStatus.OK);
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<String> searchDriver(@PathVariable int id) {
        logger.info("/searchDriver request invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}



