package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class LocationRepository implements EntityRepository<Location> {
    private static final Logger logger = LoggerFactory.getLogger(LocationRepository.class);
    private List<Location> locations = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Location location) {
        logger.info("Inside LocationRepository.store()");
        location.setLocationId(++index);
        locations.add(location);
        return true;
    }

    @Override
    public List<Location> retrieve() {
        logger.info("Inside LocationRepository.retrieve()");
        return locations;
    }

    @Override
    public Location search(int id) {
        logger.info("Inside LocationRepository.search()");
        return locations.stream().filter(l -> l.getLocationId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside LocationRepository.delete()");
        return locations.removeIf(l -> l.getLocationId() == id);
    }
}


