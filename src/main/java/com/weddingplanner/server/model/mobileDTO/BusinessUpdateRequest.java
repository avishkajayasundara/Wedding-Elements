package com.weddingplanner.server.model.mobileDTO;

public class BusinessUpdateRequest {
    String email, name, address, contactNo,description;

    public BusinessUpdateRequest() {
    }

    public BusinessUpdateRequest(String email, String name, String address, String contactNo, String description) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
