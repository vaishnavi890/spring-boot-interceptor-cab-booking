package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Cab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CabRepository implements EntityRepository<Cab> {
    private static final Logger logger = LoggerFactory.getLogger(CabRepository.class);
    private List<Cab> cabList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Cab cab) {
        logger.info("Inside CabRepository.store()");
        cab.setId(++index);
        cabList.add(index, cab);
        return true;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside CabRepository.delete()");
        cabList.remove(id);
        return true;
    }

    @Override
    public List<Cab> retrieve() {
        logger.info("Inside CabRepository.retrieve()");
        return cabList;
    }

    @Override
    public Cab search(int id) {
        logger.info("Inside CabRepository.search()");
        return cabList.get(id);
    }
}

