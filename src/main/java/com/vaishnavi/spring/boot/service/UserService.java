package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repo;

    public List<User> retrieveUsers() {
        logger.info("/inside the UserService.retrieveUsers()");
        return repo.retrieve();
    }

    public boolean storeUser(User user) {
        logger.info("/inside the UserService.storeUser()");
        return repo.store(user);
    }

    public boolean deleteUser(int id) {
        logger.info("/inside the UserService.deleteUser()");
        return repo.delete(id);
    }

    public User searchUser(int id) {
        logger.info("/inside the UserService.searchUser()");
        return repo.search(id);
    }

    public Object search(int id) {
        return null;
    }
}


