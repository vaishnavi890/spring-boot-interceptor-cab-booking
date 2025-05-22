package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.RideRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class RideRequestRepository implements EntityRepository<RideRequest> {
    private static final Logger logger = LoggerFactory.getLogger(RideRequestRepository.class);
    private List<RideRequest> requests = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(RideRequest request) {
        logger.info("Inside RideRequestRepository.store()");
        request.setRequestId(++index);
        requests.add(request);
        return true;
    }

    @Override
    public List<RideRequest> retrieve() {
        logger.info("Inside RideRequestRepository.retrieve()");
        return requests;
    }

    @Override
    public RideRequest search(int id) {
        logger.info("Inside RideRequestRepository.search()");
        return requests.stream().filter(r -> r.getRequestId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside RideRequestRepository.delete()");
        return requests.removeIf(r -> r.getRequestId() == id);
    }
}


