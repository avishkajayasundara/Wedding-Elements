package com.weddingplanner.server;

import com.weddingplanner.server.model.Review;
import com.weddingplanner.server.services.crudoperations.ReviewRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewServiceImplTest {

    List<Review> reviews;
    Review review;

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ReviewRepo reviewRepo;

    @Before
    public void before() throws Exception {
        reviews = new ArrayList<>();
        review = new Review(UUID.randomUUID().toString(), "Test", "test@gmail.com", "test", 5, UUID.randomUUID().toString());
        reviews.add(review);
        reviews.add(new Review(UUID.randomUUID().toString(), "Test", "test@gmail.com", "test", 5, review.getAdvertisementId()));
    }


    @Test
    public void testAddReview() throws Exception {
        reviewRepo.save(review);
        Assert.assertEquals(true, reviewRepo.existsById(review.getReviewId()));
    }


    @Test
    public void testRemoveReview() throws Exception {
        entityManager.persist(review);
        entityManager.flush();
        reviewRepo.deleteById(review.getReviewId());
        Assert.assertEquals(false, reviewRepo.existsById(review.getReviewId()));

    }


    @Test
    public void testGetReview() throws Exception {
       entityManager.persist(review);
       entityManager.flush();
       Review found = reviewRepo.findById(review.getReviewId()).get();
       assertThat(found.equals(review));
    }


    @Test
    public void testListReviewsByUser() throws Exception {
        entityManager.persist(review);
        entityManager.persist(reviews.get(1));
        entityManager.flush();
        Assert.assertEquals(2,reviewRepo.findByEmail("test@gmail.com").size());
    }


    @Test
    public void testListReviewByAdvertisement() throws Exception {
        entityManager.persist(review);
        entityManager.persist(reviews.get(1));
        entityManager.flush();
        Assert.assertEquals(2,reviewRepo.findByAdvertisementId(review.getAdvertisementId()).size());
    }


    @Test
    public void testDeleteReview() throws Exception {
        entityManager.persist(review);
        entityManager.flush();
        reviewRepo.deleteById(review.getReviewId());
        Assert.assertEquals(false,reviewRepo.existsById(review.getReviewId()));
    }


} 
