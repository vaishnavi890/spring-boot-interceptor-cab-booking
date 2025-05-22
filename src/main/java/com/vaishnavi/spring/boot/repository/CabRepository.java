package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Cab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class CabRepository implements EntityRepository<Cab> {
    private static final Logger logger = LoggerFactory.getLogger(CabRepository.class);
    private List<Cab> cabs = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Cab cab) {
        logger.info("Inside CabRepository.store()");
        cab.setCabId(++index);
        cabs.add(cab);
        return true;
    }

    @Override
    public List<Cab> retrieve() {
        logger.info("Inside CabRepository.retrieve()");
        return cabs;
    }

    @Override
    public Cab search(int id) {
        logger.info("Inside CabRepository.search()");
        return cabs.stream().filter(c -> c.getCabId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside CabRepository.delete()");
        return cabs.removeIf(c -> c.getCabId() == id);
    }
}


