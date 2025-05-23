package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.BookingHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingHistoryRepository implements EntityRepository<BookingHistory> {
    private static final Logger logger = LoggerFactory.getLogger(BookingHistoryRepository.class);
    private List<BookingHistory> bookingList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(BookingHistory history) {
        logger.info("Inside BookingHistoryRepository.store()");
        history.setId(++index);
        bookingList.add(index, history);
        return true;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside BookingHistoryRepository.delete()");
        bookingList.remove(id);
        return true;
    }

    @Override
    public List<BookingHistory> retrieve() {
        logger.info("Inside BookingHistoryRepository.retrieve()");
        return bookingList;
    }

    @Override
    public BookingHistory search(int id) {
        logger.info("Inside BookingHistoryRepository.search()");
        return bookingList.get(id);
    }
}


