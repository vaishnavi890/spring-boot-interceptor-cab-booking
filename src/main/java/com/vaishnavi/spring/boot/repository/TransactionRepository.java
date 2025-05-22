package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository implements EntityRepository<Transaction> {
    private static final Logger logger = LoggerFactory.getLogger(TransactionRepository.class);
    private List<Transaction> transactions = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Transaction t) {
        logger.info("Inside TransactionRepository.store()");
        t.setTransactionId(++index);
        transactions.add(t);
        return true;
    }

    @Override
    public List<Transaction> retrieve() {
        logger.info("Inside TransactionRepository.retrieve()");
        return transactions;
    }

    @Override
    public Transaction search(int id) {
        logger.info("Inside TransactionRepository.search()");
        return transactions.stream().filter(t -> t.getTransactionId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside TransactionRepository.delete()");
        return transactions.removeIf(t -> t.getTransactionId() == id);
    }
}

