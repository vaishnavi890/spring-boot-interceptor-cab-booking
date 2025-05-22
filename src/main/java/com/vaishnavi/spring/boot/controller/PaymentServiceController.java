package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.Payment;
import com.vaishnavi.spring.boot.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentServiceController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceController.class);

    @Autowired
    private PaymentService service;

    @GetMapping("/payment")
    public ResponseEntity<List<Payment>> getPayments() {
        logger.info("/payment GET invoked");
        return new ResponseEntity<>(service.retrievePayments(), HttpStatus.OK);
    }

    @PostMapping("/payment")
    public ResponseEntity<String> addPayment(@RequestParam int rideId, @RequestParam int userId,
                                             @RequestParam double amount, @RequestParam String method) {
        logger.info("/payment POST invoked");
        Payment payment = new Payment(rideId, userId, amount, method);
        return new ResponseEntity<>(service.storePayment(payment) ? "Payment added" : "Payment NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/payment/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id) {
        logger.info("/payment DELETE invoked");
        return new ResponseEntity<>(service.deletePayment(id) ? "Payment deleted" : "Payment NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<String> searchPayment(@PathVariable int id) {
        logger.info("/payment GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}



