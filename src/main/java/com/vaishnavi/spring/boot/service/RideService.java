package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Ride;
import com.vaishnavi.spring.boot.repository.RideRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    private static final Logger logger = LoggerFactory.getLogger(RideService.class);

    @Autowired
    private RideRepository repo;

    public List<Ride> retrieveRides() {
        logger.info("/inside the RideService.retrieveRides()");
        return repo.retrieve();
    }

    public boolean storeRide(Ride ride) {
        logger.info("/inside the RideService.storeRide()");
        return repo.store(ride);
    }

    public boolean deleteRide(int id) {
        logger.info("/inside the RideService.deleteRide()");
        return repo.delete(id);
    }

    public Ride searchRide(int id) {
        logger.info("/inside the RideService.searchRide()");
        return repo.search(id);
    }

    public Object search(int id) {
        return null;
    }
}


