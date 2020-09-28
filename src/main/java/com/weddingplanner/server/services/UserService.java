package com.weddingplanner.server.services;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.exceptions.ServerException;
import com.weddingplanner.server.model.Admin;
import com.weddingplanner.server.model.BusinessOwner;
import com.weddingplanner.server.model.Customer;

import java.util.List;

public interface UserService {
    void addAdminUser(Admin admin) throws ServerException, ClientException;;
    void addBusinessOwner(BusinessOwner businessOwner)throws ServerException, ClientException;;
    void removeBusinessOwner(String email);
    BusinessOwner searchBusinessOwner(String name)throws ServerException, ClientException;;
    void addCustomer(Customer customer)throws ServerException, ClientException;;
    Customer getCustomer(String email)throws ServerException, ClientException;;
    BusinessOwner getBusiness(String email) throws ServerException, ClientException;;
    List<Customer> listCustomers()throws ServerException;;
    List<BusinessOwner> listBusinessOwners() throws ServerException;;
    void updateCustomerStatus(String status, String email) throws ServerException, ClientException;;
    void updateBusinessAccountStatus(String status,String email) throws ServerException, ClientException;;
    void updateBusinessOwnerProfile(String name, String address, String contactNo, String description, String email) throws ServerException, ClientException;;
    void updateCustomerProfile(String contactNo, String address, String password, String email) throws ServerException, ClientException;;
    void removeCustomer(String email) throws ServerException, ClientException;
}
