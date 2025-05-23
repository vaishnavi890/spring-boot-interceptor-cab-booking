package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.RideRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RideRequestRepository implements EntityRepository<RideRequest> {
    private static final Logger logger = LoggerFactory.getLogger(RideRequestRepository.class);
    private List<RideRequest> rideRequestList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(RideRequest request) {
        logger.info("Inside RideRequestRepository.store()");
        request.setId(++index);
        rideRequestList.add(index, request);
        return true;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside RideRequestRepository.delete()");
        rideRequestList.remove(id);
        return true;
    }

    @Override
    public List<RideRequest> retrieve() {
        logger.info("Inside RideRequestRepository.retrieve()");
        return rideRequestList;
    }

    @Override
    public RideRequest search(int id) {
        logger.info("Inside RideRequestRepository.search()");
        return rideRequestList.get(id);
    }
}


