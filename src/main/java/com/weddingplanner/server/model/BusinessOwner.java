package com.weddingplanner.server.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class BusinessOwner extends SystemUser {

    @NotBlank(message = "The name should not be blank or null")
    private String name;
    @NotNull
    private String businessType;
    @Size(max=1000,message = "The description is too long")
    @Column(length = 500)
    private String description;
    private String country;

    public BusinessOwner(String email, String password, String address, String contactNo, String userRole, String status, String name, String businessType, String description, String country) {
        super(email, password, address, contactNo, userRole, status);
        this.name = name;
        this.businessType = businessType;
        this.description = description;
        this.country = country;
    }

    public BusinessOwner(String name, String businessType, String description, String country) {
        this.name = name;
        this.businessType = businessType;
        this.description = description;
        this.country = country;
    }

    public BusinessOwner() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}