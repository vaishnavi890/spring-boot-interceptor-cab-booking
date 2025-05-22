package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements EntityRepository<User> {
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    private List<User> users = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(User user) {
        logger.info("Inside UserRepository.store()");
        user.setUserId(++index);
        users.add(user);
        return true;
    }

    @Override
    public List<User> retrieve() {
        logger.info("Inside UserRepository.retrieve()");
        return users;
    }

    @Override
    public User search(int id) {
        logger.info("Inside UserRepository.search()");
        return users.stream().filter(u -> u.getUserId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside UserRepository.delete()");
        return users.removeIf(u -> u.getUserId() == id);
    }
}


