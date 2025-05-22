package com.vaishnavi.spring.boot.controller;

import com.vaishnavi.spring.boot.model.Transaction;
import com.vaishnavi.spring.boot.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService service;

    @GetMapping("/transaction")
    public ResponseEntity<List<Transaction>> getTransactions() {
        logger.info("/transaction GET invoked");
        return new ResponseEntity<>(service.retrieveTransactions(), HttpStatus.OK);
    }

    @PostMapping("/transaction")
    public ResponseEntity<String> addTransaction(@RequestParam int userId, @RequestParam double amount, @RequestParam String type) {
        logger.info("/transaction POST invoked");
        Transaction t = new Transaction(userId, amount, type);
        return new ResponseEntity<>(service.storeTransaction(t) ? "Transaction added" : "Transaction NOT added", HttpStatus.OK);
    }

    @DeleteMapping("/transaction/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable int id) {
        logger.info("/transaction DELETE invoked");
        return new ResponseEntity<>(service.deleteTransaction(id) ? "Transaction deleted" : "Transaction NOT deleted", HttpStatus.OK);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<String> searchTransaction(@PathVariable int id) {
        logger.info("/transaction GET by ID invoked");
        return new ResponseEntity<>(service.search(id).toString(), HttpStatus.OK);
    }
}



