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
    public void addAdvertisement(Advertisement advertisement) {
        advertisement.setAdvertisementId(UUID.randomUUID().toString());
        advertisement.setPublishedDate(new Date());
//        advertisement.setBusinessOwner("aa@gmail.com");
        advertisementRepo.save(advertisement);
    }

    @Override
    public void removeAdvertisement(String advertisementId) {
        advertisementRepo.deleteById(advertisementId);
    }

    @Override
    public void updateAdvertisement(String field, String value) {

    }

    @Override
    public void validateSignature(String signature) {

    }

    @Override
    public void approveAdvertisement(String advertisementId) {

    }

    @Override
    public void disableAdvertisement(String advertisementId) {

    }

    @Override
    public Advertisement getAdvertisement(String advertisementId) {
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
    public List<Advertisement> listAdvertisementsByCategory(String category) {
        return null;
    }

}