package com.weddingplanner.server.controller;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.exceptions.ServerException;
import com.weddingplanner.server.model.BusinessOwner;
import com.weddingplanner.server.model.Customer;
import com.weddingplanner.server.model.MyUserDetails;
import com.weddingplanner.server.services.AdvertisementService;
import com.weddingplanner.server.services.ReviewService;
import com.weddingplanner.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login.jsp");
        return mv;
    }

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
        try {
            userService.addBusinessOwner(businessOwner);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "regthank.jsp";
    }

    @PostMapping("addCustomer")
    public String addCustomer(Customer customer) {
        System.out.println("Adding New Customer");
        try {
            userService.addCustomer(customer);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "regthank.jsp";
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER', 'BUSINESS_OWNER')")
    @GetMapping("user")
    public ModelAndView addCustomer(@AuthenticationPrincipal MyUserDetails user) {
        ModelAndView modelAndView = new ModelAndView();
        if(user.getUserRole().equals("CUSTOMER")){
            try {
                modelAndView.addObject("customer", userService.getCustomer(user.getUsername()));
            } catch (ServerException e) {
                e.printStackTrace();
            } catch (ClientException e) {
                e.printStackTrace();
            }
            try {
                modelAndView.addObject("reviews", reviewService.listReviewsByUser(user.getUsername()));
            } catch (ServerException e) {
                e.printStackTrace();
            }
            modelAndView.setViewName("/user/customer.jsp");
        }else{
            try {
                modelAndView.addObject("business", userService.getBusiness(user.getUsername()));
            } catch (ServerException e) {
                e.printStackTrace();
            } catch (ClientException e) {
                e.printStackTrace();
            }
            modelAndView.addObject("advertisements",advertisementService.searchAdvertisementsByUser(user.getUsername()));
            modelAndView.setViewName("/business-owner/view_business.jsp");
        }
        modelAndView.addObject("user",user.getUsername());
        return modelAndView;
    }

    //    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("admin/business-owners")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_businesses.jsp");
        try {
            modelAndView.addObject("businesses", userService.listBusinessOwners());
        } catch (ServerException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    //    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("admin/business-owners/")
    public ModelAndView getBusinessOwner(String email) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/business-owner/view_business.jsp");
        try {
            modelAndView.addObject("business", userService.getBusiness(email));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("advertisements", advertisementService.searchAdvertisementsByUser(email));
        return modelAndView;
    }

    @GetMapping("admin/customers/")
    public ModelAndView getCustomer(String email) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_customer.jsp");
        try {
            modelAndView.addObject("customer", userService.getCustomer(email));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        try {
            modelAndView.addObject("reviews", reviewService.listReviewsByUser(email));
        } catch (ServerException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @GetMapping("admin/customers")
    public ModelAndView getCustomers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_customers.jsp");
        try {
            modelAndView.addObject("customers", userService.listCustomers());
        } catch (ServerException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
    @GetMapping("admin/customers/update-status")
    public ModelAndView updateCustomerStatus(String status, String email) {
        try {
            userService.updateCustomerStatus(status,email);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_customer.jsp");
        try {
            modelAndView.addObject("customer", userService.getCustomer(email));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
    @GetMapping("admin/business-owners/update-status")
    public ModelAndView updateBusinessAccountStatus(String status, String email) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/business-owner/view_business.jsp");
        try {
            userService.updateBusinessAccountStatus(status, email);
            modelAndView.addObject("business", userService.getBusiness(email));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("advertisements", advertisementService.searchAdvertisementsByUser(email));
        return modelAndView;
    }
    @PostMapping("business-owners/update-profile")
    public ModelAndView updateProfile(String email, String name, String address, String contactNo,String description) throws ServerException, ClientException {
        userService.updateBusinessOwnerProfile(name,address,contactNo,description,email);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("business", userService.getBusiness(email));
        modelAndView.addObject("advertisements",advertisementService.searchAdvertisementsByUser(email));
        modelAndView.setViewName("/business-owner/view_business.jsp");
        modelAndView.addObject("user",email);
        return modelAndView;
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER')")
    @PostMapping("customer/update-profile")
    public ModelAndView updateCustomerProfile(String contactNo, String address, String password, String email) {
        try {
            userService.updateCustomerProfile(contactNo, address, password, email);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.addObject("customer", userService.getCustomer(email));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/user/customer.jsp");
        try {
            modelAndView.addObject("reviews", reviewService.listReviewsByUser(email));
        } catch (ServerException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("user", email);
        return modelAndView;
    }
    @GetMapping("view-business")
    public ModelAndView viewBusiness(String email){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_business.jsp");
        try {
            modelAndView.addObject("business", userService.getBusiness(email));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("advertisements", advertisementService.searchAdvertisementsByUser(email));
        if (SecurityContextHolder.getContext().getAuthentication().getName() != "anonymousUser")
            modelAndView.addObject("user", SecurityContextHolder.getContext().getAuthentication().getName());
        return modelAndView;
    }

    @GetMapping("customer/delete")
    public ModelAndView deleteCustomer(String email) {
        try {
            userService.removeCustomer(email);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/logout");
    }
}