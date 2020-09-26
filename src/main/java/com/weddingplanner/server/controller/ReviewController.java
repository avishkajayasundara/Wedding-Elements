package com.weddingplanner.server.controller;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.exceptions.ServerException;
import com.weddingplanner.server.model.Customer;
import com.weddingplanner.server.model.MyUserDetails;
import com.weddingplanner.server.model.Review;
import com.weddingplanner.server.services.AdvertisementService;
import com.weddingplanner.server.services.ReviewService;
import com.weddingplanner.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewController {

    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @PreAuthorize("hasAnyAuthority('CUSTOMER')")
    @PostMapping("user/addReview")
    public ModelAndView addReview(ModelMap model, Review review, @AuthenticationPrincipal MyUserDetails user) {
        Customer customer = null;
        try {
            customer = userService.getCustomer(user.getUsername());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        ModelAndView mv = new ModelAndView();
        review.setEmail(user.getUsername());
        review.setName(customer.getFirstName()
                + " " + customer.getLastName());
        try {
            reviewService.addReview(review);
        } catch (ServerException e) {
            e.printStackTrace();
        }
        model.addAttribute("advertisementId", review.getAdvertisementId());
        return new ModelAndView("redirect:/advertisement", model);
    }

    //@PreAuthorize("hasAnyAuthority('CUSTOMER')")
    @GetMapping("admin/delete-review")
    public ModelAndView deleteReview(ModelMap model,String reviewId, String email) {
        try {
            reviewService.deleteReview(reviewId);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        model.addAttribute("email", email);
        return new ModelAndView("redirect:/admin/customers/", model);
    }

}