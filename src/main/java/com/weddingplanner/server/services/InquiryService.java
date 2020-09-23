package com.weddingplanner.server.services;

import com.weddingplanner.server.model.Inquiry;

import java.util.List;

public interface InquiryService {
    public void addInquiry(Inquiry inquiry);
    public Inquiry getInquiry(String inquiryId);
    public List<Inquiry> listInquiries();
    public void removeInquiry(String id);
}
