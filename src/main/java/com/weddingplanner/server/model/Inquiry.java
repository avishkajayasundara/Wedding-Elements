package com.weddingplanner.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Inquiry {

    @Id
    private String inquiryId;
    @NotBlank(message = "Name Should Not Be Blank")
    private String name;
    @NotBlank
    @Email
    private String email;
    private String contactNo;
    @NotBlank
    private String subject;
    @Column(length = 500)
    @Size(max=500)
    private String message;

    public Inquiry(String inquiryId, String name, String email, String contactNo, String subject, String message) {
        this.inquiryId = inquiryId;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.subject = subject;
        this.message = message;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public Inquiry(String name, String email, String contactNo, String subject, String message) {
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.subject = subject;
        this.message = message;
    }

    public Inquiry() {
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
