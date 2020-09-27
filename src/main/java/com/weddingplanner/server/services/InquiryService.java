package com.weddingplanner.server.services;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.exceptions.ServerException;
import com.weddingplanner.server.model.Inquiry;

import java.util.List;

public interface InquiryService extends GeneralServices {
    public void addInquiry(Inquiry inquiry)throws ServerException, ClientException;;
    public Inquiry getInquiry(String inquiryId)throws ServerException, ClientException;;
    public List<Inquiry> listInquiries() throws ClientException;
    public void removeInquiry(String id) throws ServerException;
}
