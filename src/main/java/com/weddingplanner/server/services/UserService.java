package com.weddingplanner.server.services;

import com.weddingplanner.server.model.Admin;
import com.weddingplanner.server.model.BusinessOwner;
import com.weddingplanner.server.model.Customer;

import java.util.List;

public interface UserService {
    boolean validateUserRole(String expectedRole,String userId);
    void addAdminUser(Admin admin);
    void addBusinessOwner(BusinessOwner businessOwner);
    void removeAdmin(String email);
    void removeBusinessOwner(String email);
    List<BusinessOwner> listUsers();
    void disableUserAccount(String email);
    BusinessOwner searchBusinessOwner(String name);
    void updateAccountDetails();
    void addCustomer(Customer customer);
    Customer getCustomer(String email);
    BusinessOwner getBusiness(String email);
    List<Customer> listCustomers();
    List<BusinessOwner> listBusinessOwners();
    void updateCustomerStatus(String status, String email);
    void updateBusinessAccountStatus(String status,String email);
    void updateBusinessOwnerProfile(String name, String address, String contactNo, String description, String email);
    void updateCustomerProfile(String contactNo, String address, String password, String email);

}
