package com.weddingplanner.server.services.crudoperations;

import com.weddingplanner.server.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemUserRepository extends JpaRepository<SystemUser,String> {
    Optional<SystemUser> findByEmail(String email);
}
