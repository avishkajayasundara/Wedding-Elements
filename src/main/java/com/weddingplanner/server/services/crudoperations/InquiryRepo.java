package com.weddingplanner.server.services.crudoperations;

import com.weddingplanner.server.model.Inquiry;
import org.springframework.data.repository.CrudRepository;

public interface InquiryRepo extends CrudRepository<Inquiry,String> {

}
