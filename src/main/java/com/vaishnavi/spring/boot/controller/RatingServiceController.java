package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.Rating;
import com.vaishnavi.spring.boot.service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingServiceController {
    private static final Logger logger = LoggerFactory.getLogger(RatingServiceController.class);

    @Autowired
    private RatingService service;

    @GetMapping("/rating")
    public ResponseEntity<List<Rating>> getRatings() {
        logger.info("/rating GET invoked");
        return new ResponseEntity<>(service.retrieveRatings(), HttpStatus.OK);
    }

    @PostMapping("/rating")
    public ResponseEntity<String> addRating(@RequestParam int rideId, @RequestParam int userId,
                                            @RequestParam int driverId, @RequestParam int rating,
                                            @RequestParam String review) {
        logger.info("/rating POST invoked");
        Rating r = new Rating(rideId, userId, driverId, rating, review);
        return new ResponseEntity<>(service.storeRating(r) ? "Rating added" : "Rating NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/rating/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable int id) {
        logger.info("/rating DELETE invoked");
        return new ResponseEntity<>(service.deleteRating(id) ? "Rating deleted" : "Rating NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/rating/{id}")
    public ResponseEntity<String> searchRating(@PathVariable int id) {
        logger.info("/rating GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}



