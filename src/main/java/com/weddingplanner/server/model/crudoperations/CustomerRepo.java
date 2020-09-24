package com.weddingplanner.server.model.crudoperations;

import com.weddingplanner.server.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepo extends CrudRepository<Customer, String> {
    @Modifying
    @Query("update Customer customer set customer.status = ?1 where customer.email = ?2")
    void updateCustomerStatus(String status, String email);

    @Modifying
    @Query("update Customer customer set customer.contactNo = ?1, customer.address = ?2, customer.password = ?3 where customer.email = ?4")
    void updateProfileDetails(String contactNo, String address, String password, String email);
}
