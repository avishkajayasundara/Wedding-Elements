package com.weddingplanner.server.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public abstract class SystemUser {
    @Id
    @Email
    private String email;
    @Size(min = 6,message = "The password should at least be six characters long")
    private String password;
    @NotBlank(message = "The address should not be long")
    private String address;
    @NotBlank
    private String contactNo;
    private String userRole;
    private String status;


    public SystemUser(String email, String password, String address, String contactNo, String userRole, String status) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.contactNo = contactNo;
        this.userRole = userRole;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public SystemUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
