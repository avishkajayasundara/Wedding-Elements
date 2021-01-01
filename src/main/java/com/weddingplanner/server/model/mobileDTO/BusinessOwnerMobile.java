package com.weddingplanner.server.model.mobileDTO;

import com.weddingplanner.server.model.Advertisement;
import com.weddingplanner.server.model.BusinessOwner;

import java.util.List;

public class BusinessOwnerMobile {
    BusinessOwner businessOwner;
    List<Advertisement> advertisements;

    public BusinessOwnerMobile(BusinessOwner businessOwner, List<Advertisement> advertisements) {
        this.businessOwner = businessOwner;
        this.advertisements = advertisements;
    }

    public BusinessOwnerMobile() {
    }

    public BusinessOwner getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(BusinessOwner businessOwner) {
        this.businessOwner = businessOwner;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }
}
