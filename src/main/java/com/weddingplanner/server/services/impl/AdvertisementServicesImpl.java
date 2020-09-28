package com.weddingplanner.server.services.impl;

import com.weddingplanner.server.model.Advertisement;
import com.weddingplanner.server.model.crudoperations.AdvertisementRepo;
import com.weddingplanner.server.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("AdvertisementService")
public class AdvertisementServicesImpl implements AdvertisementService {

    @Autowired
    AdvertisementRepo advertisementRepo;

    @Override
    public void add(Object object) {
        Advertisement advertisement = (Advertisement) object;
        advertisement.setAdvertisementId(UUID.randomUUID().toString());
        advertisement.setPublishedDate(new Date());
        advertisement.setNumberOfReviews(0);
        advertisementRepo.save(advertisement);
    }

    @Override
    public void removeById(String advertisementId) {
        advertisementRepo.deleteById(advertisementId);
    }

    @Override
    public Object retrieveById(String advertisementId) {
        return advertisementRepo.findById(advertisementId).get();
    }

    @Override
    public List<Advertisement> searchAdvertisementsByUser(String email) {
        return advertisementRepo.findByBusinessOwner(email);
    }

    @Override
    public List<Advertisement> listAdvertisements() {
        List<Advertisement> result = new ArrayList<Advertisement>();
        Iterable iterable = advertisementRepo.findAll();
        for (Object str : iterable) {
            result.add((Advertisement) str);
        }
        return result;
    }

    @Override
    public void updateAdvertisementRating(Float score, int noOfReviews, String advertisementId) {
        advertisementRepo.updateScore(score, noOfReviews, advertisementId);
    }

    @Override
    public void updateAdvertisementDetails(String description, Double startingPrice, String advertisementId) {
        advertisementRepo.updateAdvertisementDetails(description, startingPrice, advertisementId);
    }

}