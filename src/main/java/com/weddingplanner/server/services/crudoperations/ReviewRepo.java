package com.weddingplanner.server.services.crudoperations;

import com.weddingplanner.server.model.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepo extends CrudRepository<Review,String> {
    List<Review> findByAdvertisementId(String advertisementId);
    List<Review> findByEmail(String email);
}
