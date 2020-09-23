package com.weddingplanner.server.model.crudoperations;

import com.weddingplanner.server.model.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepo extends CrudRepository<Review,String> {
    List<Review> findByAdvertisementId(String advertisementId);
}
