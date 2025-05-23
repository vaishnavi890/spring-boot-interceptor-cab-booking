package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.BookingHistory;
import com.vaishnavi.spring.boot.repository.BookingHistoryRepository;
import com.vaishnavi.spring.boot.service.BookingHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingHistoryServiceController {

    private static final Logger logger = LoggerFactory.getLogger(BookingHistoryRepository.class);

    @Autowired
    private BookingHistoryService service;

    @RequestMapping(value = "/bookinghistory", method = RequestMethod.GET)
    public ResponseEntity<List<BookingHistory>> getBookingHistories() {
        logger.info("/bookinghistory GET request invoked in controller");
        return new ResponseEntity<>(service.retrieveBookingHistories(), HttpStatus.OK);
    }

    @PostMapping(value = "/bookinghistory")
    public ResponseEntity<String> addBookingHistory(
            @RequestParam(name = "userId") int userId,
            @RequestParam(name = "rideId") int rideId,
            @RequestParam(name = "status") String status,
            @RequestParam(name = "timestamp") String timestamp
    ) {
        logger.info("/bookinghistory POST request invoked in controller");
        BookingHistory booking = new BookingHistory(userId, rideId, status, timestamp);
        return new ResponseEntity<>(
                service.storeBookingHistory(booking) ? "Booking history added" : "Failed to add booking history",
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/bookinghistory/{id}")
    public ResponseEntity<String> removeBookingHistory(@PathVariable int id) {
        logger.info("/bookinghistory DELETE request invoked in controller");
        return new ResponseEntity<>(
                service.deleteBookingHistory(id) ? "Booking history removed" : "Booking history NOT removed",
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/bookinghistory/{id}")
    public ResponseEntity<String> searchBookingHistory(@PathVariable int id) {
        logger.info("/bookinghistory/{id} GET request invoked in controller");
        return new ResponseEntity<>(
                service.search(id).toString(),
                HttpStatus.OK
        );
    }
}


