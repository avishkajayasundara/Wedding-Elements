package com.weddingplanner.server.services;

import com.weddingplanner.server.model.Advertisement;

import java.util.List;

public interface AdvertisementService extends GeneralServices {
    List<Advertisement> searchAdvertisementsByUser(String email);
    List<Advertisement> listAdvertisements();
    void updateAdvertisementRating(Float score,int noOfReviews,String advertisementId);
    void updateAdvertisementDetails(String description, Double startingPrice, String advertisementId);
}
