package com.weddingplanner.server.services;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.exceptions.ServerException;
import com.weddingplanner.server.model.Review;

import java.util.List;

public interface ReviewService extends GeneralServices {
    void addReview(Review review) throws ServerException;;
    void removeReview(String reviewId)throws ServerException, ClientException;;
    Review getReview(String reviewId) throws ServerException, ClientException;;
    List<Review> listReviewsByUser(String email) throws ServerException;
    List<Review> listReviewByAdvertisement(String advertisementId)throws ServerException, ClientException;;
    void deleteReview(String reviewId) throws ServerException, ClientException;;
}
