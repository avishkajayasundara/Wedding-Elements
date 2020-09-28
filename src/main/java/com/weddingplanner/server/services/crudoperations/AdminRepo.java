package com.weddingplanner.server.services.crudoperations;

import com.weddingplanner.server.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin,String> {
}