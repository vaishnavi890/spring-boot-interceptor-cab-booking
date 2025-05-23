package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Driver;
import com.vaishnavi.spring.boot.repository.DriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private static final Logger logger = LoggerFactory.getLogger(DriverService.class);

    @Autowired
    private DriverRepository repo;

    public List<Driver> retrieveDrivers() {
        logger.info("/inside the DriverService.retrieveDrivers()");
        return repo.retrieve();
    }

    public boolean storeDriver(Driver driver) {
        logger.info("/inside the DriverService.storeDriver()");
        return repo.store(driver);
    }

    public boolean deleteDriver(int id) {
        logger.info("/inside the DriverService.deleteDriver()");
        return repo.delete(id);
    }

    public Driver searchDriver(int id) {
        logger.info("/inside the DriverService.searchDriver()");
        return repo.search(id);
    }

    public Object search(int id) {
        return null;
    }
}

