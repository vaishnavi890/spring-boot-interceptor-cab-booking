package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class DriverRepository implements EntityRepository<Driver> {
    private static final Logger logger = LoggerFactory.getLogger(DriverRepository.class);
    private List<Driver> drivers = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Driver driver) {
        logger.info("Inside DriverRepository.store()");
        driver.setDriverId(++index);
        drivers.add(driver);
        return true;
    }

    @Override
    public List<Driver> retrieve() {
        logger.info("Inside DriverRepository.retrieve()");
        return drivers;
    }

    @Override
    public Driver search(int id) {
        logger.info("Inside DriverRepository.search()");
        return drivers.stream().filter(d -> d.getDriverId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside DriverRepository.delete()");
        return drivers.removeIf(d -> d.getDriverId() == id);
    }
}


