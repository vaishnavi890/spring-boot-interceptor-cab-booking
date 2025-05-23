package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.BookingHistory;
import com.vaishnavi.spring.boot.repository.BookingHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(BookingHistoryService.class);

    @Autowired
    private BookingHistoryRepository repository;

    public List<BookingHistory> retrieveBookingHistories() {
        logger.info("/inside the BookingHistoryService.retrieveBookingHistories()");
        return repository.retrieve();
    }

    public boolean storeBookingHistory(BookingHistory history) {
        logger.info("/inside the BookingHistoryService.storeBookingHistory()");
        return repository.store(history);
    }

    public boolean deleteBookingHistory(int id) {
        logger.info("/inside the BookingHistoryService.deleteBookingHistory()");
        return repository.delete(id);
    }

    public BookingHistory searchBookingHistory(int id) {
        logger.info("/inside the BookingHistoryService.searchBookingHistory()");
        return repository.search(id);
    }

    public Object search(int id) {
        return null;
    }
}




