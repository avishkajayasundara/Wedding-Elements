package com.weddingplanner.server.services;

import com.weddingplanner.server.model.Review;

import java.util.List;

public interface ReviewService {

    void addReview(Review review);
    void removeReview(String reviewId);
    Review getReview(String reviewId);
    List<Review> listReviewsByUser(String email);
    List<Review> listReviewByAdvertisement(String advertisementId);
    void deleteReview(String reviewId);
}
