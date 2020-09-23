package com.weddingplanner.server.controller;

import com.weddingplanner.server.model.Customer;
import com.weddingplanner.server.model.MyUserDetails;
import com.weddingplanner.server.model.Review;
import com.weddingplanner.server.services.AdvertisementService;
import com.weddingplanner.server.services.ReviewService;
import com.weddingplanner.server.services.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView addReview(Review review, @AuthenticationPrincipal MyUserDetails user){
        Customer customer = userService.getCustomer(user.getUsername());
        ModelAndView mv = new ModelAndView();
        review.setEmail(user.getUsername());
        review.setName(customer.getFirstName() + " " + customer.getLastName());
        reviewService.addReview(review);
        mv.setViewName("advertisement.jsp");
        mv.addObject("advertisement", advertisementService.getAdvertisement(review.getAdvertisementId()));
        mv.addObject("reviews", reviewService.listReviewByAdvertisement(review.getAdvertisementId()));
        return mv;
    }
    //@PreAuthorize("hasAnyAuthority('CUSTOMER')")
    @GetMapping("admin/delete-review")
    public void deleteReview(String reviewId){
       reviewService.deleteReview(reviewId);

    }
}
