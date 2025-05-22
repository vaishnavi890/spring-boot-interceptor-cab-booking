package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.BookingHistory;
import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.BookingHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookingHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(BookingHistoryService.class);
    private BookingHistoryRepository repo = new BookingHistoryRepository();

    public List<User> getAllHistories() {
        logger.info("Inside BookingHistoryService.getAllHistories()");
        return repo.findAll();
    }

    public boolean addHistory(BookingHistory history) {
        logger.info("Inside BookingHistoryService.addHistory()");
        return repo.save(history);
    }

    public boolean deleteHistory(int historyId) {
        logger.info("Inside BookingHistoryService.deleteHistory()");
        return repo.delete(historyId);
    }

    public User getHistoryById(int historyId) {
        logger.info("Inside BookingHistoryService.getHistoryById()");
        return repo.findById(historyId);
    }

    public boolean updateHistory(BookingHistory history) {
        logger.info("Inside BookingHistoryService.updateHistory()");
        return repo.update(history);
    }

    public List<BookingHistory> retrieveHistories() {
        return List.of();
    }

    public boolean storeHistory(BookingHistory h) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}



