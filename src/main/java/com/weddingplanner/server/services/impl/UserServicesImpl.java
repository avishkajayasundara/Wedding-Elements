package com.weddingplanner.server.services.impl;

import com.weddingplanner.server.model.Admin;
import com.weddingplanner.server.model.Advertisement;
import com.weddingplanner.server.model.BusinessOwner;
import com.weddingplanner.server.model.Customer;
import com.weddingplanner.server.model.crudoperations.AdminRepo;
import com.weddingplanner.server.model.crudoperations.BusinessOwnerRepo;
import com.weddingplanner.server.model.crudoperations.CustomerRepo;
import com.weddingplanner.server.model.crudoperations.InquiryRepo;
import com.weddingplanner.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserService")
public class UserServicesImpl implements UserService {

    @Autowired
    InquiryRepo inquiryRepo;

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    BusinessOwnerRepo businessOwnerRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean validateUserRole(String expectedRole, String userId) {
        return false;
    }

    @Override
    public void addAdminUser(Admin admin) {
        System.out.println("Implement");
    }

    @Override
    public void addBusinessOwner(BusinessOwner businessOwner) {
        businessOwner.setUserRole("BUSINESS_OWNER");
        businessOwner.setStatus("PENDING");
        businessOwner.setPassword(passwordEncoder.encode(businessOwner.getPassword()));
        businessOwnerRepo.save(businessOwner);
        System.out.println("Added New Business");
    }

    @Override
    public void removeAdmin(String email) {

    }
    @Override
    public void removeBusinessOwner(String email) {
        businessOwnerRepo.deleteById(email);
    }

    @Override
    public List<BusinessOwner> listUsers() {
        return null;
    }

    @Override
    public void disableUserAccount(String email) {
    }

    @Override
    public BusinessOwner searchBusinessOwner(String name) {
        return null;
    }

    @Override
    public void updateAccountDetails() {

    }

    @Override
    public void addCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setUserRole("CUSTOMER");
        customer.setStatus("ACTIVE");
        customerRepo.save(customer);
    }

    @Override
    public Customer getCustomer(String email) {
        return customerRepo.findById(email).get();
    }

    @Override
    public BusinessOwner getBusiness(String email) {
        return businessOwnerRepo.findById(email).get();
    }

    @Override
    public List<Customer> listCustomers() {
        List<Customer> result = new ArrayList<Customer>();
        Iterable iterable = customerRepo.findAll();
        for (Object str : iterable) {
            result.add((Customer) str);
        }
        return result;
    }

    @Override
    public List<BusinessOwner> listBusinessOwners() {
        List<BusinessOwner> result = new ArrayList<BusinessOwner>();
        Iterable iterable = businessOwnerRepo.findAll();
        for (Object str : iterable) {
            result.add((BusinessOwner) str);
        }
        return result;
    }

    @Override
    public void updateCustomerStatus(String status, String email) {
        customerRepo.updateCustomerStatus(status,email);
    }

    @Override
    public void updateBusinessAccountStatus(String status,String email) {
        businessOwnerRepo.updateAccountStatus(status, email);
    }

    @Override
    public void updateBusinessOwnerProfile(String name, String address, String contactNo, String description, String email) {
        businessOwnerRepo.updateProfileDetails(name,address,contactNo,description,email);
    }

    @Override
    public void updateCustomerProfile(String contactNo, String address, String password, String email) {
        customerRepo.updateProfileDetails(contactNo, address, passwordEncoder.encode(password), email);
    }
}