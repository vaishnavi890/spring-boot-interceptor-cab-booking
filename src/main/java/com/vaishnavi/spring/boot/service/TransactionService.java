package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Transaction;
import com.vaishnavi.spring.boot.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository repo;

    public List<Transaction> retrieveTransactions() {
        logger.info("/inside the TransactionService.retrieveTransactions()");
        return repo.retrieve();
    }

    public boolean storeTransaction(Transaction transaction) {
        logger.info("/inside the TransactionService.storeTransaction()");
        return repo.store(transaction);
    }

    public boolean deleteTransaction(int id) {
        logger.info("/inside the TransactionService.deleteTransaction()");
        return repo.delete(id);
    }

    public Transaction searchTransaction(int id) {
        logger.info("/inside the TransactionService.searchTransaction()");
        return repo.search(id);
    }

    public Object search(int id) {
        return null;
    }
}

