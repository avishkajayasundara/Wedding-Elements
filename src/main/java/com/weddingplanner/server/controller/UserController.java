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
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
    public ModelAndView addBusiness(@Valid BusinessOwner businessOwner, Errors errors) {
        if (errors.hasErrors()) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ClientException(401, "Registration Failed. Please Try Again"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        }
        try {
            userService.addBusinessOwner(businessOwner);
        } catch (ServerException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        } catch (ClientException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ClientException(401, "Registration Failed. Please Try Again"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        }
        return new ModelAndView("redirect:/");
    }

    @PostMapping("addCustomer")
    public ModelAndView addCustomer(@Valid Customer customer, Errors errors) {
        if (errors.hasErrors()) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ClientException(401, "Registration Failed. Please Try Again"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        }
        try {
            userService.addCustomer(customer);
        } catch (ServerException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        } catch (ClientException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ClientException(401, "Registration Failed. Please Try Again"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        }
        return new ModelAndView("redirect:/");
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER', 'BUSINESS_OWNER')")
    @GetMapping("user")
    public ModelAndView getCustomer(@AuthenticationPrincipal MyUserDetails user) {
        ModelAndView modelAndView = new ModelAndView();
        if(user.getUserRole().equals("CUSTOMER")){
            try {
                modelAndView.addObject("customer", userService.getCustomer(user.getUsername()));
            } catch (ServerException e) {
                ModelMap model = new ModelMap();
                model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
                model.addAttribute("errorType", "ClientException");
                return new ModelAndView("redirect:/error", model);
            } catch (ClientException e) {
                ModelMap model = new ModelMap();
                model.addAttribute("error", new ClientException(401, "Invalid Request.Please Try Again"));
                model.addAttribute("errorType", "ClientException");
                return new ModelAndView("redirect:/error", model);
            }
            try {
                modelAndView.addObject("reviews", reviewService.listReviewsByUser(user.getUsername()));
            } catch (ServerException e) {
                ModelMap model = new ModelMap();
                model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
                model.addAttribute("errorType", "ClientException");
                return new ModelAndView("redirect:/error", model);
            }
            modelAndView.setViewName("/user/customer.jsp");
        }else{
            try {
                modelAndView.addObject("business", userService.getBusiness(user.getUsername()));
            } catch (ServerException e) {
                ModelMap model = new ModelMap();
                model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
                model.addAttribute("errorType", "ClientException");
                return new ModelAndView("redirect:/error", model);
            } catch (ClientException e) {
                ModelMap model = new ModelMap();
                model.addAttribute("error", new ClientException(401, "RInvalid Request.Please Try Again"));
                model.addAttribute("errorType", "ClientException");
                return new ModelAndView("redirect:/error", model);
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
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        }
        return modelAndView;
    }

    //    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("admin/business-owners/")
    public ModelAndView getBusinessOwner(String email) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/business-owners/view_business.jsp");
        try {
            modelAndView.addObject("business", userService.getBusiness(email));
        } catch (ServerException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        } catch (ClientException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ClientException(401, "Invalid Request.Please Try Again"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
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
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        } catch (ClientException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ClientException(401, "Invalid Request.Please Try Again"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        }
        try {
            modelAndView.addObject("reviews", reviewService.listReviewsByUser(email));
        } catch (ServerException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
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
    @GetMapping("admin")
    public ModelAndView adminDashboard() {
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("/admin/dashboard.jsp");
       return modelAndView;
    }
    @GetMapping("admin/customer/delete")
    public ModelAndView adminRemoveCustomer(ModelMap model,String email) throws ServerException, ClientException {
        userService.removeCustomer(email);
        return new ModelAndView("redirect:/admin/customers");
    }
    @GetMapping("admin/business/delete")
    public ModelAndView adminRemoveBusiness(ModelMap model,String email) {
        userService.removeBusinessOwner(email);
        return new ModelAndView("redirect:/admin/customers");
    }
}