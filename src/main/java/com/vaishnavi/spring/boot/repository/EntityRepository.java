package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.BookingHistory;
import com.vaishnavi.spring.boot.model.User;

import java.util.List;

public interface EntityRepository<T> {
    boolean store(T entity);
    List<T> retrieve();
    T search(int id);
    boolean delete(int id);

    boolean update(BookingHistory user);

    User findById(int userId);

    boolean save(BookingHistory user);

    List<User> findAll();

    boolean markRead(int notificationId);
}


