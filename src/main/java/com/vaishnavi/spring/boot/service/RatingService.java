package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Rating;
import com.vaishnavi.spring.boot.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private static final Logger logger = LoggerFactory.getLogger(RatingService.class);

    @Autowired
    private RatingRepository repo;

    public List<Rating> retrieveRatings() {
        logger.info("/inside the RatingService.retrieveRatings()");
        return repo.retrieve();
    }

    public boolean storeRating(Rating rating) {
        logger.info("/inside the RatingService.storeRating()");
        return repo.store(rating);
    }

    public boolean deleteRating(int id) {
        logger.info("/inside the RatingService.deleteRating()");
        return repo.delete(id);
    }

    public Rating searchRating(int id) {
        logger.info("/inside the RatingService.searchRating()");
        return repo.search(id);
    }

    public Object search(int id) {
        return null;
    }
}



