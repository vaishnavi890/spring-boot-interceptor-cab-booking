package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationRepository implements EntityRepository<Location> {
    private static final Logger logger = LoggerFactory.getLogger(LocationRepository.class);
    private List<Location> locationList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Location location) {
        logger.info("Inside LocationRepository.store()");
        location.setId(++index);
        locationList.add(index, location);
        return true;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside LocationRepository.delete()");
        locationList.remove(id);
        return true;
    }

    @Override
    public List<Location> retrieve() {
        logger.info("Inside LocationRepository.retrieve()");
        return locationList;
    }

    @Override
    public Location search(int id) {
        logger.info("Inside LocationRepository.search()");
        return locationList.get(id);
    }
}


