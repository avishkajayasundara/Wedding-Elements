package com.weddingplanner.server.services.crudoperations;

import com.weddingplanner.server.model.Advertisement;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AdvertisementRepo extends CrudRepository<Advertisement,String> {
    List<Advertisement> findByBusinessOwner(String businessOwner);

    @Modifying
    @Query("update Advertisement advertisement set advertisement.score = ?1, advertisement.numberOfReviews = ?2 where advertisement.advertisementId = ?3")
    void updateScore(Float score, int noOfReviews, String advertisementId);

    @Modifying
    @Query("update Advertisement advertisement set advertisement.Description = ?1, advertisement.startingPrice = ?2 where advertisement.advertisementId = ?3")
    void updateAdvertisementDetails(String description, Double startingPrice, String advertisementId);
}