package com.weddingplanner.server.services;

import com.weddingplanner.server.model.Advertisement;

import java.util.List;

public interface AdvertisementService {
    void addAdvertisement(Advertisement advertisement);
    void removeAdvertisement(String advertisementId);
    void updateAdvertisement(String field, String value);
    void validateSignature(String signature);
    void approveAdvertisement(String advertisementId);
    void disableAdvertisement(String advertisementId);
    Advertisement getAdvertisement(String advertisementId);
    List<Advertisement> searchAdvertisementsByUser(String email);
    List<Advertisement> listAdvertisements();
    List<Advertisement> listAdvertisementsByCategory(String category);
    void updateAdvertisementRating(Float score,int noOfReviews,String advertisementId);
    void updateAdvertisementDetails(String description, Double startingPrice, String advertisementId);

}
