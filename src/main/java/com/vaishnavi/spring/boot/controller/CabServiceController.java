package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.Cab;
import com.vaishnavi.spring.boot.service.CabService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CabServiceController {
    private static final Logger logger = LoggerFactory.getLogger(CabServiceController.class);

    @Autowired
    private CabService service;

    @GetMapping("/cab")
    public ResponseEntity<List<Cab>> getCabs() {
        logger.info("/cab GET invoked");
        return new ResponseEntity<>(service.retrieveCabs(), HttpStatus.OK);
    }

    @PostMapping("/cab")
    public ResponseEntity<String> addCab(@RequestParam String model, @RequestParam String plate, @RequestParam int driverId) {
        logger.info("/cab POST invoked");
        Cab cab = new Cab(model, plate, driverId);
        return new ResponseEntity<>(service.storeCab(cab) ? "Cab added" : "Cab NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/cab/{id}")
    public ResponseEntity<String> deleteCab(@PathVariable int id) {
        logger.info("/cab DELETE invoked");
        return new ResponseEntity<>(service.deleteCab(id) ? "Cab deleted" : "Cab NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/cab/{id}")
    public ResponseEntity<String> searchCab(@PathVariable int id) {
        logger.info("/cab GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}


