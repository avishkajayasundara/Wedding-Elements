package com.weddingplanner.server.services.impl;

import com.weddingplanner.server.model.Inquiry;
import com.weddingplanner.server.model.crudoperations.InquiryRepo;
import com.weddingplanner.server.services.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("InquiryService")
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    InquiryRepo inquiryRepo;

    @Override
    public void addInquiry(Inquiry inquiry) {
        inquiry.setInquiryId(UUID.randomUUID().toString());
        inquiryRepo.save(inquiry);
    }

    @Override
    public Inquiry getInquiry(String inquiryId) {
        return null;
    }

    @Override
    public List<Inquiry> listInquiries() {
        return null;
    }

    @Override
    public void removeInquiry(String id) {

    }
}
