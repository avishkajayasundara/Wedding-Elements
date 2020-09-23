package com.weddingplanner.server.services.impl;

import com.weddingplanner.server.model.Review;
import com.weddingplanner.server.model.crudoperations.ReviewRepo;
import com.weddingplanner.server.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("ReviewService")
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public void addReview(Review review) {
        review.setReviewId(UUID.randomUUID().toString());
        reviewRepo.save(review);
    }

    @Override
    public void removeReview(String reviewId) {
        reviewRepo.deleteById(reviewId);
    }

    @Override
    public Review getReview(String reviewId) {
        return null;
    }

    @Override
    public List<Review> listReviewsByUser(String email) {
        return null;
    }

    @Override
    public List<Review> listReviewByAdvertisement(String advertisementId) {
        return reviewRepo.findByAdvertisementId(advertisementId);
    }
}