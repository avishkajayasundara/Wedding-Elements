package com.weddingplanner.server.controller;

import com.weddingplanner.server.model.BusinessOwner;
import com.weddingplanner.server.model.Customer;
import com.weddingplanner.server.model.MyUserDetails;
import com.weddingplanner.server.services.AdvertisementService;
import com.weddingplanner.server.services.ReviewService;
import com.weddingplanner.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    SessionRegistry sessionRegistry;

    @GetMapping("newBusiness")
    public ModelAndView newBusiness() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerBusiness.jsp");
        System.out.println("New Business");
        return modelAndView;
    }

    @GetMapping("/newCustomer")
    public ModelAndView newCustomer() {
        System.out.println("new Customer");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerCustomer.jsp");
        return modelAndView;
    }

    @PostMapping("addBusiness")
    public String addBusiness(BusinessOwner businessOwner) {
        System.out.println("Adding New Business");
        userService.addBusinessOwner(businessOwner);
        return "regthank.jsp";
    }

    @PostMapping("addCustomer")
    public String addCustomer(Customer customer) {
        System.out.println("Adding New Customer");
        userService.addCustomer(customer);
        return "regthank.jsp";
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER', 'BUSINESS_OWNER')")
    @GetMapping("user")
    public ModelAndView addCustomer(@AuthenticationPrincipal MyUserDetails user) {
        ModelAndView modelAndView = new ModelAndView();
        if(user.getUserRole().equals("CUSTOMER")){
            modelAndView.addObject("customer", userService.getCustomer(user.getUsername()));
            modelAndView.addObject("reviews", reviewService.listReviewsByUser(user.getUsername()));
            modelAndView.setViewName("/user/customer.jsp");
        }else{
            modelAndView.addObject("business", userService.getBusiness(user.getUsername()));
            modelAndView.addObject("advertisements",advertisementService.searchAdvertisementsByUser(user.getUsername()));
            modelAndView.setViewName("/view_business.jsp");
        }
        modelAndView.addObject("user",user.getUsername());
        return modelAndView;
    }

    //    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("admin/business-owners")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_businesses.jsp");
        modelAndView.addObject("businesses", userService.listBusinessOwners());
        return modelAndView;
    }

    //    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("admin/business-owners/")
    public ModelAndView getBusinessOwner(String email) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_business.jsp");
        modelAndView.addObject("business", userService.getBusiness(email));
        modelAndView.addObject("advertisements", advertisementService.searchAdvertisementsByUser(email));
        return modelAndView;
    }

    @GetMapping("admin/customers/")
    public ModelAndView getCustomer(String email) {
        System.out.println(email);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_customer.jsp");
        modelAndView.addObject("customer", userService.getCustomer(email));
        modelAndView.addObject("reviews", reviewService.listReviewsByUser(email));
        return modelAndView;
    }

    @GetMapping("admin/customers")
    public ModelAndView getCustomers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_customers.jsp");
        modelAndView.addObject("customers", userService.listCustomers());
        return modelAndView;
    }
    @GetMapping("admin/customers/update-status")
    public ModelAndView updateCustomerStatus(String status, String email) {
        userService.updateCustomerStatus(status,email);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_customer.jsp");
        modelAndView.addObject("customer", userService.getCustomer(email));
        return modelAndView;
    }
    @GetMapping("admin/business-owners/update-status")
    public ModelAndView updateBusinessAccountStatus(String status, String email) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_business.jsp");
        userService.updateBusinessAccountStatus(status, email);
        modelAndView.addObject("business", userService.getBusiness(email));
        modelAndView.addObject("advertisements", advertisementService.searchAdvertisementsByUser(email));
        return modelAndView;
    }
    @PostMapping("business-owners/update-profile")
    public ModelAndView updateProfile(String email, String name, String address, String contactNo,String description) {
        userService.updateBusinessOwnerProfile(name,address,contactNo,description,email);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("business", userService.getBusiness(email));
        modelAndView.addObject("advertisements",advertisementService.searchAdvertisementsByUser(email));
        modelAndView.setViewName("/view_business.jsp");
        modelAndView.addObject("user",email);
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login.jsp");
        return mv;
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER')")
    @PostMapping("customer/update-profile")
    public ModelAndView updateCustomerProfile(String contactNo, String address, String password, String email) {
        userService.updateCustomerProfile(contactNo, address, password, email);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer", userService.getCustomer(email));
        modelAndView.setViewName("/user/customer.jsp");
        modelAndView.addObject("reviews", reviewService.listReviewsByUser(email));
        modelAndView.addObject("user", email);
        return modelAndView;
    }
}