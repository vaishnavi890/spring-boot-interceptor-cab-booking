package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.RideRequest;
import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.RideRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RideRequestService {

    private static final Logger logger = LoggerFactory.getLogger(RideRequestService.class);
    private RideRequestRepository repo = new RideRequestRepository();

    public List<User> getAllRequests() {
        logger.info("Inside RideRequestService.getAllRequests()");
        return repo.findAll();
    }

    public boolean addRequest(RideRequest request) {
        logger.info("Inside RideRequestService.addRequest()");
        return repo.save(request);
    }

    public boolean deleteRequest(int requestId) {
        logger.info("Inside RideRequestService.deleteRequest()");
        return repo.delete(requestId);
    }

    public User getRequestById(int requestId) {
        logger.info("Inside RideRequestService.getRequestById()");
        return repo.findById(requestId);
    }

    public boolean updateRequest(RideRequest request) {
        logger.info("Inside RideRequestService.updateRequest()");
        return repo.update(request);
    }

    public List<RideRequest> retrieveRideRequests() {
        return List.of();
    }

    public boolean storeRideRequest(RideRequest req) {
        return false;
    }

    public boolean deleteRideRequest(int id) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}


