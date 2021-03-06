package com.weddingplanner.server.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Review {

    @Id
    private String reviewId;
    private String name;
    private String email;
    @Size(max = 1000)
    @NotBlank(message = "This field should not be blank")
    private String review;

    @Max(10)
    @PositiveOrZero
    private int score;
    private String advertisementId;

    public Review(String reviewId, String name, String email, String review,
                  int score, String advertisementId) {
        this.reviewId = reviewId;
        this.name = name;
        this.email = email;
        this.review = review;
        this.score = score;
        this.advertisementId = advertisementId;
    }

    public Review() {
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(String advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
