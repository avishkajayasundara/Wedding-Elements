package com.weddingplanner.server.model.crudoperations;

import com.weddingplanner.server.model.Inquiry;
import org.springframework.data.repository.CrudRepository;

public interface InquiryRepo extends CrudRepository<Inquiry,String> {

}
