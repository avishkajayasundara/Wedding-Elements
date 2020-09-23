package com.weddingplanner.server.controller;

import com.weddingplanner.server.model.Advertisement;
import com.weddingplanner.server.model.MyUserDetails;
import com.weddingplanner.server.model.Review;
import com.weddingplanner.server.services.AdvertisementService;
import com.weddingplanner.server.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.jar.JarOutputStream;

@Controller
public class AdvertisementController {

    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    ReviewService reviewService;

    @RequestMapping("/categories")
    @ResponseBody
    public ModelAndView home() {
        System.out.println("Executing code");
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex", new Review());
        mv.setViewName("categories.jsp");
        return mv;
    }

    @GetMapping("/")
    @ResponseBody
    public ModelAndView homepage() {
        List<Advertisement> advertisements = advertisementService.listAdvertisements();
        ModelAndView mv = new ModelAndView();
        mv.addObject("advertisements", advertisements);
        if (SecurityContextHolder.getContext().getAuthentication().getName() != "anonymousUser")
            mv.addObject("user", SecurityContextHolder.getContext().getAuthentication().getName());
        mv.setViewName("home.jsp");
        return mv;
    }
//    @GetMapping("/advertisements")
//    @ResponseBody
    @RequestMapping(value="/advertisements", method = RequestMethod.GET)
    public ModelAndView getAdvertisements() {
        List<Advertisement> advertisements = advertisementService.listAdvertisements();
        ModelAndView mv = new ModelAndView();
        mv.addObject("advertisements", advertisements);
        if (SecurityContextHolder.getContext().getAuthentication().getName() != "anonymousUser")
            mv.addObject("user", SecurityContextHolder.getContext().getAuthentication().getName());
        mv.setViewName("advertisements.jsp");
        return mv;
    }

    @PreAuthorize("hasAnyAuthority('BUSINESS_OWNER')")
    @GetMapping("/business-owner/newAdvertisement")
    public ModelAndView newAdvertisement() {
        System.out.println("New Advertisement");
        ModelAndView mv = new ModelAndView();
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        mv.addObject("user", SecurityContextHolder.getContext().getAuthentication().getName());
        mv.setViewName("/business-owner/newAdvertisement.jsp");
        return mv;
    }

    @PreAuthorize("hasAnyAuthority('BUSINESS_OWNER')")
    @PostMapping("/business-owner/addAdvertisement")
    public ModelAndView addAdvertisement(Advertisement advertisement, @AuthenticationPrincipal MyUserDetails user) {
        System.out.println("Adding New Advertisement");
        advertisement.setBusinessOwner(user.getUsername());
        advertisementService.addAdvertisement(advertisement);
        ModelAndView mv = new ModelAndView();
        mv.addObject("advertisement", advertisement);
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        mv.addObject("user", SecurityContextHolder.getContext().getAuthentication().getName());
        mv.setViewName("/business-owner/advertisementPreview.jsp");
        return mv;
    }

    @GetMapping("advertisement")
    public ModelAndView getAdvertisement(String advertisementId){
        System.out.println(advertisementId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("advertisement.jsp");
        mv.addObject("advertisement", advertisementService.getAdvertisement(advertisementId));
        mv.addObject("reviews", reviewService.listReviewByAdvertisement(advertisementId));
        return mv;
    }

}
