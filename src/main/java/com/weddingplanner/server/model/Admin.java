package com.weddingplanner.server.model;



import javax.persistence.Entity;

@Entity
public class Admin extends SystemUser{
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String nicNo;
    private String employeeId;

    public Admin(String firstName, String lastName, String dob, String gender,
                 String nicNo, String employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.nicNo = nicNo;
        this.employeeId = employeeId;
    }

    public Admin() {
    }

    public Admin(String email, String password, String address, String contactNo, String userRole, String status, String firstName, String lastName, String dob, String gender, String nicNo, String employeeId) {
        super(email, password, address, contactNo, userRole, status);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.nicNo = nicNo;
        this.employeeId = employeeId;
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

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
