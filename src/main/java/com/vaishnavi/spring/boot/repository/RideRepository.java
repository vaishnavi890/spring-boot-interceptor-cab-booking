package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Ride;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class RideRepository implements EntityRepository<Ride> {
    private static final Logger logger = LoggerFactory.getLogger(RideRepository.class);
    private List<Ride> rideList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Ride ride) {
        logger.info("Inside RideRepository.store()");
        ride.setRideId(++index);
        rideList.add(ride);
        return true;
    }

    @Override
    public List<Ride> retrieve() {
        logger.info("Inside RideRepository.retrieve()");
        return rideList;
    }

    @Override
    public Ride search(int id) {
        logger.info("Inside RideRepository.search()");
        return rideList.stream().filter(r -> r.getRideId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside RideRepository.delete()");
        return rideList.removeIf(r -> r.getRideId() == id);
    }
}


