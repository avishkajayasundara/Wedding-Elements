package com.weddingplanner.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Advertisement {

    @Id
    private String advertisementId;
    private String title;
    @Column(length = 500)
    private String Description;
    private String image;
    private String businessOwner;
    private Date publishedDate;
    private String category;
    private Double startingPrice;
    private Float score;

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    private int numberOfReviews;

    public Advertisement(String advertisementId, String title, String description, String image, String businessOwner,
                         Date publishedDate, String category, Double startingPrice,int numberOfReviews, Float score ) {
        this.advertisementId = advertisementId;
        this.title = title;
        Description = description;
        this.image = image;
        this.businessOwner = businessOwner;
        this.publishedDate = publishedDate;
        this.category = category;
        this.startingPrice = startingPrice;
        this.numberOfReviews = numberOfReviews;
        this.score = score;
    }

    public Advertisement() {
    }

    public String getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(String advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(String businessOwner) {
        this.businessOwner = businessOwner;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
    }
}
