package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.BookingHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class BookingHistoryRepository implements EntityRepository<BookingHistory> {
    private static final Logger logger = LoggerFactory.getLogger(BookingHistoryRepository.class);
    private List<BookingHistory> history = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(BookingHistory b) {
        logger.info("Inside BookingHistoryRepository.store()");
        b.setBookingId(++index);
        history.add(b);
        return true;
    }

    @Override
    public List<BookingHistory> retrieve() {
        logger.info("Inside BookingHistoryRepository.retrieve()");
        return history;
    }

    @Override
    public BookingHistory search(int id) {
        logger.info("Inside BookingHistoryRepository.search()");
        return history.stream().filter(b -> b.getBookingId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside BookingHistoryRepository.delete()");
        return history.removeIf(b -> b.getBookingId() == id);
    }
}


