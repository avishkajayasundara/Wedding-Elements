package com.weddingplanner.server.model.crudoperations;

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
}
