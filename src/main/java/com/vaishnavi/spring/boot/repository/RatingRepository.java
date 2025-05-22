package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class RatingRepository implements EntityRepository<Rating> {
    private static final Logger logger = LoggerFactory.getLogger(RatingRepository.class);
    private List<Rating> ratings = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Rating rating) {
        logger.info("Inside RatingRepository.store()");
        rating.setRatingId(++index);
        ratings.add(rating);
        return true;
    }

    @Override
    public List<Rating> retrieve() {
        logger.info("Inside RatingRepository.retrieve()");
        return ratings;
    }

    @Override
    public Rating search(int id) {
        logger.info("Inside RatingRepository.search()");
        return ratings.stream().filter(r -> r.getRatingId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside RatingRepository.delete()");
        return ratings.removeIf(r -> r.getRatingId() == id);
    }
}


