package com.weddingplanner.server.controller;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.exceptions.ServerException;
import com.weddingplanner.server.model.Advertisement;
import com.weddingplanner.server.model.MyUserDetails;
import com.weddingplanner.server.services.AdvertisementService;
import com.weddingplanner.server.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdvertisementController {

    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    ReviewService reviewService;


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
    @RequestMapping(value = "/advertisements", method = RequestMethod.GET)
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
    public ModelAndView addAdvertisement(@Valid Advertisement advertisement, @AuthenticationPrincipal MyUserDetails user, Errors errors) {
        if (errors.hasErrors()) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ClientException(401, "Your Review was not added. Please Try Again"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        }
        advertisement.setBusinessOwner(user.getUsername());
        advertisementService.add(advertisement);
        ModelAndView mv = new ModelAndView();
        mv.addObject("advertisement", advertisement);
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        mv.addObject("user", SecurityContextHolder.getContext().getAuthentication().getName());
        mv.setViewName("/business-owner/advertisementPreview.jsp");
        return mv;
    }

    @GetMapping("advertisement")
    public ModelAndView getAdvertisement(String advertisementId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("advertisement.jsp");
        Advertisement advertisement = (Advertisement) advertisementService.retrieveById(advertisementId);
        advertisement.setScore(advertisement.getScore() / advertisement.getNumberOfReviews());
        if (SecurityContextHolder.getContext().getAuthentication().getName() != "anonymousUser")
            mv.addObject("user", SecurityContextHolder.getContext().getAuthentication().getName());
        mv.addObject("advertisement", advertisement);
        try {
            mv.addObject("reviews", reviewService.listReviewByAdvertisement(advertisementId));
        } catch (ServerException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        } catch (ClientException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ClientException(401, "Bad Request. Please Try Again"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        }
        return mv;
    }

    @GetMapping("business-owners/advertisement")
    public ModelAndView getAdvertisementToEdit(String advertisementId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/business-owner/advertisement.jsp");
        Advertisement advertisement = (Advertisement) advertisementService.retrieveById(advertisementId);
        advertisement.setScore(advertisement.getScore() / advertisement.getNumberOfReviews());
        mv.addObject("advertisement", advertisement);
        try {
            mv.addObject("reviews", reviewService.listReviewByAdvertisement(advertisementId));
        } catch (ServerException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ServerException(500, "Something Went Wrong"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        } catch (ClientException e) {
            ModelMap model = new ModelMap();
            model.addAttribute("error", new ClientException(401, "Bad Request. Please Try Again"));
            model.addAttribute("errorType", "ClientException");
            return new ModelAndView("redirect:/error", model);
        }
        return mv;
    }

    @PostMapping("business-owners/update-advertisement")
    public ModelAndView updateAdvertisement(ModelMap model, String description, Double startingPrice, String advertisementId) {
        advertisementService.updateAdvertisementDetails(description, startingPrice, advertisementId);
        model.addAttribute("advertisementId", advertisementId);
        return new ModelAndView("redirect:/business-owners/advertisement", model);
    }
}
