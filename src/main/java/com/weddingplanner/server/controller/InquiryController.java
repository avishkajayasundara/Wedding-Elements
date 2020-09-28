package com.weddingplanner.server.controller;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.exceptions.ServerException;
import com.weddingplanner.server.model.Inquiry;
import com.weddingplanner.server.services.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
    public ModelAndView addInquiry(@Valid Inquiry inquiry, Errors errors){
        if(errors.hasErrors()){
            ModelMap model = new ModelMap();
            model.addAttribute("error",new ClientException(401,"Your Review was not added. Please Try Again"));
            model.addAttribute("errorType","ClientException");
            return new ModelAndView("redirect:/error", model);
        }
        try {
            inquiryService.add(inquiry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/");
    }
    @GetMapping("admin/inquiries")
    public ModelAndView listInquiries(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/inquiries.jsp");
        try {
            modelAndView.addObject("inquiries", inquiryService.listInquiries());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
    @RequestMapping("admin/inquiry/delete")
    public String addInquiry(String inquiryId){
        try {
            inquiryService.removeInquiry(inquiryId);
        } catch (Exception | ServerException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/inquiries";
    }

}
