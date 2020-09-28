package com.weddingplanner.server.services.impl;

import com.weddingplanner.server.model.Advertisement;
import com.weddingplanner.server.model.Review;
import com.weddingplanner.server.services.crudoperations.AdvertisementRepo;
import com.weddingplanner.server.services.crudoperations.ReviewRepo;
import com.weddingplanner.server.services.AdvertisementService;
import com.weddingplanner.server.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("ReviewService")
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    AdvertisementRepo advertisementRepo;

    @Autowired
    AdvertisementService advertisementService;

    @Override
    public void addReview(Review review) {
        Advertisement advertisement = advertisementRepo.findById(review.getAdvertisementId()).get();
        advertisement.setNumberOfReviews(advertisement.getNumberOfReviews() + 1);
        Float newScore = (advertisement.getScore() + review.getScore());
        review.setReviewId(UUID.randomUUID().toString());
        reviewRepo.save(review);
        advertisementService.updateAdvertisementRating(newScore, advertisement.getNumberOfReviews(), review.getAdvertisementId());
    }

    @Override
    public void removeReview(String reviewId) {
        reviewRepo.deleteById(reviewId);
    }

    @Override
    public Review getReview(String reviewId) {
        return reviewRepo.findById(reviewId).get();
    }

    @Override
    public List<Review> listReviewsByUser(String email) {
        return reviewRepo.findByEmail(email);
    }

    @Override
    public List<Review> listReviewByAdvertisement(String advertisementId) {
        return reviewRepo.findByAdvertisementId(advertisementId);
    }

    @Override
    public void deleteReview(String reviewId) {
        reviewRepo.deleteById(reviewId);
    }

    @Override
    public void add(Object object) {
        Review review = (Review) object;
        Advertisement advertisement = advertisementRepo.findById(review.getAdvertisementId()).get();
        advertisement.setNumberOfReviews(advertisement.getNumberOfReviews() + 1);
        Float newScore = (advertisement.getScore() + review.getScore());
        review.setReviewId(UUID.randomUUID().toString());
        reviewRepo.save(review);
        advertisementService.updateAdvertisementRating(newScore, advertisement.getNumberOfReviews(), review.getAdvertisementId());
    }

    @Override
    public void removeById(String id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public Object retrieveById(String id) {
        return reviewRepo.findById(id).get();
    }
}