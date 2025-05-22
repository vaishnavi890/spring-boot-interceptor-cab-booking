package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.BookingHistory;
import com.vaishnavi.spring.boot.service.BookingHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingHistoryController {
    private static final Logger logger = LoggerFactory.getLogger(BookingHistoryController.class);

    @Autowired
    private BookingHistoryService service;

    @GetMapping("/bookinghistory")
    public ResponseEntity<List<BookingHistory>> getHistories() {
        logger.info("/bookinghistory GET invoked");
        return new ResponseEntity<>(service.retrieveHistories(), HttpStatus.OK);
    }

    @PostMapping("/bookinghistory")
    public ResponseEntity<String> addHistory(@RequestParam int userId, @RequestParam int rideId) {
        logger.info("/bookinghistory POST invoked");
        BookingHistory h = new BookingHistory(userId, rideId);
        return new ResponseEntity<>(service.storeHistory(h) ? "History added" : "History NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/bookinghistory/{id}")
    public ResponseEntity<String> deleteHistory(@PathVariable int id) {
        logger.info("/bookinghistory DELETE invoked");
        return new ResponseEntity<>(service.deleteHistory(id) ? "History deleted" : "History NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/bookinghistory/{id}")
    public ResponseEntity<String> searchHistory(@PathVariable int id) {
        logger.info("/bookinghistory GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}


