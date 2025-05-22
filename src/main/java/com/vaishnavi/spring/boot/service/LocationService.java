package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Location;
import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LocationService {

    private static final Logger logger = LoggerFactory.getLogger(LocationService.class);
    private LocationRepository repo = new LocationRepository();

    public List<User> getAllLocations() {
        logger.info("Inside LocationService.getAllLocations()");
        return repo.findAll();
    }

    public boolean addLocation(Location location) {
        logger.info("Inside LocationService.addLocation()");
        return repo.save(location);
    }

    public boolean deleteLocation(int locationId) {
        logger.info("Inside LocationService.deleteLocation()");
        return repo.delete(locationId);
    }

    public User getLocationById(int locationId) {
        logger.info("Inside LocationService.getLocationById()");
        return repo.findById(locationId);
    }

    public boolean updateLocation(Location location) {
        logger.info("Inside LocationService.updateLocation()");
        return repo.update(location);
    }

    public List<Location> retrieveLocations() {
        return List.of();
    }

    public boolean storeLocation(Location l) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}


