package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Location;
import com.vaishnavi.spring.boot.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private static final Logger logger = LoggerFactory.getLogger(LocationService.class);

    @Autowired
    private LocationRepository repo;

    public List<Location> retrieveLocations() {
        logger.info("/inside the LocationService.retrieveLocations()");
        return repo.retrieve();
    }

    public boolean storeLocation(Location location) {
        logger.info("/inside the LocationService.storeLocation()");
        return repo.store(location);
    }

    public boolean deleteLocation(int id) {
        logger.info("/inside the LocationService.deleteLocation()");
        return repo.delete(id);
    }

    public Location searchLocation(int id) {
        logger.info("/inside the LocationService.searchLocation()");
        return repo.search(id);
    }

    public Object search(int id) {
        return null;
    }
}


