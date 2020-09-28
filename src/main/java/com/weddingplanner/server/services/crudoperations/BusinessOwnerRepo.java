package com.weddingplanner.server.services.crudoperations;

import com.weddingplanner.server.model.BusinessOwner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BusinessOwnerRepo extends CrudRepository<BusinessOwner,String> {
    @Modifying
    @Query("update BusinessOwner owner set owner.status = ?1 where owner.email = ?2")
    void updateAccountStatus(String status, String email);

    @Modifying
    @Query("update BusinessOwner owner set owner.name = ?1, owner.address = ?2, owner.contactNo = ?3, owner.description = ?4 where owner.email = ?5")
    void updateProfileDetails(String name, String address, String contactNo, String description, String email);
}
