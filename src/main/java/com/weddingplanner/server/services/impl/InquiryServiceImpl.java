package com.weddingplanner.server.services.impl;

import com.weddingplanner.server.model.Inquiry;
import com.weddingplanner.server.model.crudoperations.InquiryRepo;
import com.weddingplanner.server.services.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return inquiryRepo.findById(inquiryId).get();
    }

    @Override
    public List<Inquiry> listInquiries() {
        List<Inquiry> result = new ArrayList<Inquiry>();
        Iterable iterable = inquiryRepo.findAll();
        for (Object str : iterable) {
            result.add((Inquiry) str);
        }
        return result;
    }

    @Override
    public void removeInquiry(String id) {
        inquiryRepo.deleteById(id);
    }

    @Override
    public void add(Object object) {
        Inquiry inquiry = (Inquiry) object;
        inquiry.setInquiryId(UUID.randomUUID().toString());
        inquiryRepo.save(inquiry);
    }

    @Override
    public void removeById(String id) {
        System.out.println("Implement");
    }

    @Override
    public Object retrieveById(String id) {
        return null;
    }
}
