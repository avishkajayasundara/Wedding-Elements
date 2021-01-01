package com.weddingplanner.server.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer extends SystemUser {

    @NotBlank(message = "The first name is mandatory")
    private String firstName;
    @NotBlank(message = "The last name is mandatory")
    private String lastName;
    private String dob;
    @NotBlank(message = "This field should not be blank")
    private String gender;


    public Customer(String email, String password, String address, String contactNo, String userRole, String status, String firstName, String lastName, String dob, String gender) {
        super(email, password, address, contactNo, userRole, status);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
    }

    public Customer(String firstName, String lastName, String dob, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
    }

    public Customer() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
