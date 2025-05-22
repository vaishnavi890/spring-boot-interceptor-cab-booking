package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Transaction;
import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
    private TransactionRepository repo = new TransactionRepository();

    public List<User> getAllTransactions() {
        logger.info("Inside TransactionService.getAllTransactions()");
        return repo.findAll();
    }

    public boolean addTransaction(Transaction transaction) {
        logger.info("Inside TransactionService.addTransaction()");
        return repo.save(transaction);
    }

    public boolean deleteTransaction(int transactionId) {
        logger.info("Inside TransactionService.deleteTransaction()");
        return repo.delete(transactionId);
    }

    public User getTransactionById(int transactionId) {
        logger.info("Inside TransactionService.getTransactionById()");
        return repo.findById(transactionId);
    }

    public boolean updateTransaction(Transaction transaction) {
        logger.info("Inside TransactionService.updateTransaction()");
        return repo.update(transaction);
    }

    public List<Transaction> retrieveTransactions() {
        return List.of();
    }

    public boolean storeTransaction(Transaction t) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}

