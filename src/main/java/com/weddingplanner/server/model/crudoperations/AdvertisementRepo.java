package com.weddingplanner.server.model.crudoperations;

import com.weddingplanner.server.model.Advertisement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvertisementRepo extends CrudRepository<Advertisement,String> {
    List<Advertisement> findByBusinessOwner(String businessOwner);
}