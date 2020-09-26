package com.weddingplanner.server.controller;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.exceptions.ServerException;
import com.weddingplanner.server.model.Inquiry;
import com.weddingplanner.server.services.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InquiryController {

    @Autowired
    InquiryService inquiryService;

    @RequestMapping("contact")
    public String contactUs(){
        System.out.println("Redirecting to Contact Us");
        return "contact.jsp";
    }

    @RequestMapping("newInquiry")
    public String addInquiry(Inquiry inquiry){
        System.out.println("New Inquiry");
        try {
            inquiryService.addInquiry(inquiry);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "index.jsp";
    }

}
