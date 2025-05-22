package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Ride;
import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.RideRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RideService {

    private static final Logger logger = LoggerFactory.getLogger(RideService.class);
    private RideRepository repo = new RideRepository();

    public List<User> getAllRides() {
        logger.info("Inside RideService.getAllRides()");
        return repo.findAll();
    }

    public boolean bookRide(Ride ride) {
        logger.info("Inside RideService.bookRide()");
        return repo.save(ride);
    }

    public boolean deleteRide(int rideId) {
        logger.info("Inside RideService.deleteRide()");
        return repo.delete(rideId);
    }

    public User getRideById(int rideId) {
        logger.info("Inside RideService.getRideById()");
        return repo.findById(rideId);
    }

    public boolean updateRide(Ride ride) {
        logger.info("Inside RideService.updateRide()");
        return repo.update(ride);
    }

    public List<Ride> retrieveRides() {
        return List.of();
    }

    public boolean storeRide(Ride ride) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}


