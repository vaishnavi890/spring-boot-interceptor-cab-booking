package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Cab;
import com.vaishnavi.spring.boot.repository.CabRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabService {

    private static final Logger logger = LoggerFactory.getLogger(CabService.class);

    @Autowired
    private CabRepository repo;

    public List<Cab> retrieveCabs() {
        logger.info("/inside the CabService.retrieveCabs()");
        return repo.retrieve();
    }

    public boolean storeCab(Cab cab) {
        logger.info("/inside the CabService.storeCab()");
        return repo.store(cab);
    }

    public boolean deleteCab(int id) {
        logger.info("/inside the CabService.deleteCab()");
        return repo.delete(id);
    }

    public Cab searchCab(int id) {
        logger.info("/inside the CabService.searchCab()");
        return repo.search(id);
    }

    public Object search(int id) {
        return null;
    }
}



