package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Cab;
import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.CabRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CabService {

    private static final Logger logger = LoggerFactory.getLogger(CabService.class);
    private CabRepository repo = new CabRepository();

    public List<User> getAllCabs() {
        logger.info("Inside CabService.getAllCabs()");
        return repo.findAll();
    }

    public boolean addCab(Cab cab) {
        logger.info("Inside CabService.addCab()");
        return repo.save(cab);
    }

    public boolean deleteCab(int cabId) {
        logger.info("Inside CabService.deleteCab()");
        return repo.delete(cabId);
    }

    public User getCabById(int cabId) {
        logger.info("Inside CabService.getCabById()");
        return repo.findById(cabId);
    }

    public boolean updateCab(Cab cab) {
        logger.info("Inside CabService.updateCab()");
        return repo.update(cab);
    }

    public List<Cab> retrieveCabs() {
        return List.of();
    }

    public boolean storeCab(Cab cab) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}



