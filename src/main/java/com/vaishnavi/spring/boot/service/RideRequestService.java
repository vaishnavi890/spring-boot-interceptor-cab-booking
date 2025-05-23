package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.RideRequest;
import com.vaishnavi.spring.boot.repository.RideRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideRequestService {

    private static final Logger logger = LoggerFactory.getLogger(RideRequestService.class);

    @Autowired
    private RideRequestRepository repo;

    public List<RideRequest> retrieveRideRequests() {
        logger.info("/inside the RideRequestService.retrieveRideRequests()");
        return repo.retrieve();
    }

    public boolean storeRideRequest(RideRequest request) {
        logger.info("/inside the RideRequestService.storeRideRequest()");
        return repo.store(request);
    }

    public boolean deleteRideRequest(int id) {
        logger.info("/inside the RideRequestService.deleteRideRequest()");
        return repo.delete(id);
    }

    public RideRequest searchRideRequest(int id) {
        logger.info("/inside the RideRequestService.searchRideRequest()");
        return repo.search(id);
    }

    public Object search(int id) {
        return null;
    }
}
