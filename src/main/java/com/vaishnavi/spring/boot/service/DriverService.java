package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Driver;
import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.DriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DriverService {

    private static final Logger logger = LoggerFactory.getLogger(DriverService.class);
    private DriverRepository repo = new DriverRepository();

    public List<User> getAllDrivers() {
        logger.info("Inside DriverService.getAllDrivers()");
        return repo.findAll();
    }

    public boolean registerDriver(Driver driver) {
        logger.info("Inside DriverService.registerDriver()");
        return repo.save(driver);
    }

    public boolean deleteDriver(int driverId) {
        logger.info("Inside DriverService.deleteDriver()");
        return repo.delete(driverId);
    }

    public User getDriverById(int driverId) {
        logger.info("Inside DriverService.getDriverById()");
        return repo.findById(driverId);
    }

    public boolean updateDriver(Driver driver) {
        logger.info("Inside DriverService.updateDriver()");
        return repo.update(driver);
    }

    public List<Driver> retrieveDrivers() {
        return List.of();
    }

    public boolean storeDriver(Driver driver) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}


