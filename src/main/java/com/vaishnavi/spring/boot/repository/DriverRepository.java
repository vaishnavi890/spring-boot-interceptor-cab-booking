package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverRepository implements EntityRepository<Driver> {
    private static final Logger logger = LoggerFactory.getLogger(DriverRepository.class);
    private List<Driver> driverList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Driver driver) {
        logger.info("Inside DriverRepository.store()");
        driver.setId(++index);
        driverList.add(index, driver);
        return true;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside DriverRepository.delete()");
        driverList.remove(id);
        return true;
    }

    @Override
    public List<Driver> retrieve() {
        logger.info("Inside DriverRepository.retrieve()");
        return driverList;
    }

    @Override
    public Driver search(int id) {
        logger.info("Inside DriverRepository.search()");
        return driverList.get(id);
    }
}


