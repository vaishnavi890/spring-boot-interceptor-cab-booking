package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Rating;
import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RatingService {

    private static final Logger logger = LoggerFactory.getLogger(RatingService.class);
    private RatingRepository repo = new RatingRepository();

    public List<User> getAllRatings() {
        logger.info("Inside RatingService.getAllRatings()");
        return repo.findAll();
    }

    public boolean addRating(Rating rating) {
        logger.info("Inside RatingService.addRating()");
        return repo.save(rating);
    }

    public boolean deleteRating(int ratingId) {
        logger.info("Inside RatingService.deleteRating()");
        return repo.delete(ratingId);
    }

    public User getRatingById(int ratingId) {
        logger.info("Inside RatingService.getRatingById()");
        return repo.findById(ratingId);
    }

    public boolean updateRating(Rating rating) {
        logger.info("Inside RatingService.updateRating()");
        return repo.update(rating);
    }

    public List<Rating> retrieveRatings() {
        return List.of();
    }

    public boolean storeRating(Rating r) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}



