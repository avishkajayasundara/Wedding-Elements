package com.weddingplanner.server.controller;

import com.weddingplanner.server.exceptions.ClientException;
import com.weddingplanner.server.exceptions.ServerException;
import com.weddingplanner.server.messaging.model.PushNotificationRequest;
import com.weddingplanner.server.messaging.services.PushNotificationService;
import com.weddingplanner.server.model.*;
import com.weddingplanner.server.model.mobileDTO.*;
import com.weddingplanner.server.services.AdvertisementService;
import com.weddingplanner.server.services.InquiryService;
import com.weddingplanner.server.services.ReviewService;
import com.weddingplanner.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileController {


    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    UserService userService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    InquiryService inquiryService;

    @Autowired
    PushNotificationService pushNotificationService;

    @PostMapping("/customer")
    public String registerCustomer(@RequestBody Customer customer) throws ServerException, ClientException {
        userService.addCustomer(customer);
        return customer.getEmail();
    }

    @PutMapping("/customer")
    public void updateCustomerDetails(@RequestBody CustomerUpdateRequest request) throws ServerException, ClientException {
        userService.updateCustomerProfile(request.getContactNo(), request.getAddress(), request.getPassword(), request.getEmail());
    }

    @GetMapping(value="customers", produces = "application/json")
    public List<Customer> getAllCustomers() throws ServerException {
        return userService.listCustomers();
    }
    @DeleteMapping("customer/{email}")
    public void deleteCustomer(@PathVariable String email) throws ServerException, ClientException {
        userService.removeCustomer(email);
    }

    @PostMapping(value = "/business-owner", produces = "application/json")
    public BusinessOwner registerBusiness(@RequestBody BusinessOwner businessOwner) throws ServerException, ClientException {
        userService.addBusinessOwner(businessOwner);
        return businessOwner;
    }

    @PostMapping(value="/advertisement",produces = "application/json")
    public Advertisement addAdvertisement(@RequestBody Advertisement advertisement) {
        advertisementService.add(advertisement);
        return advertisement;
    }

    @DeleteMapping(value="/advertisement/{advertisementId}")
    public void removeAdvertisement(@PathVariable String advertisementId) {
        advertisementService.removeById(advertisementId);
    }
    @GetMapping(value="business-owners", produces = "application/json")
    public List<BusinessOwner> getAllBusinesses() throws ServerException {
        return userService.listBusinessOwners();
    }


    @DeleteMapping("/business-owner/{email}")
    public void removeBusinessOwner(@PathVariable String email) {
        userService.removeBusinessOwner(email);
    }

    @PostMapping("/review")
    public void addReview(@RequestBody CustomerUpdateRequest review) {

    }

    @GetMapping(value = "/customer/{email}", produces = "application/json")
    public Customer getCustomer(@PathVariable String email) throws ServerException, ClientException {
        Customer customer = userService.getCustomer(email);
        return customer;
    }

    @GetMapping(value = "/business-owner/{email}", produces = "application/json")
    public BusinessOwnerMobile getBusinessOwner(@PathVariable String email) throws ServerException, ClientException {
        BusinessOwnerMobile owner = new BusinessOwnerMobile();
        owner.setBusinessOwner(userService.getBusiness(email));
        owner.setAdvertisements(advertisementService.searchAdvertisementsByUser(email));
        return owner;
    }


    @PutMapping("business-owner")
    public void updateBusinessProfile(@RequestBody BusinessUpdateRequest request) throws ServerException, ClientException {
        userService.updateBusinessOwnerProfile(
                request.getName(),request.getAddress(),request.getContactNo(),request.getDescription(),request.getEmail()
        );
    }

    @GetMapping(value = "/advertisements", produces = "application/json")
    public List<Advertisement> getAllAdvertisements() {
        List<Advertisement> advs = advertisementService.listAdvertisements();
        return advs;
    }

    @GetMapping(value = "/advertisement/reviews/{advertisementId}", produces = "application/json")
    public List<Review> getReviewsByAdvertisement(@PathVariable String advertisementId) throws ServerException, ClientException {
        List<Review> reviews = reviewService.listReviewByAdvertisement(advertisementId);
        return reviews;
    }

    @DeleteMapping(value = "/advertisement")
    public void deleteAdvertisement(@PathVariable String advertisementId) {

    }

    @DeleteMapping(value = "/review/{reviewId}")
    public void deleteReview(@PathVariable String reviewId) throws ServerException, ClientException {
        reviewService.deleteReview(reviewId);
    }

    @GetMapping(value = "reviews/{email}", produces = "application/json")
    public List<Review> getReviewsByCustomer(@PathVariable String email) throws ServerException {
        return reviewService.listReviewsByUser(email);
    }

    @PostMapping(value = "/inquiry", produces = "application/json")
    public Inquiry addInquiry(@RequestBody Inquiry inquiry) throws ServerException, ClientException {
        return null;
    }

    @PostMapping(value = "/login", produces = "application/json")
    public LoggedInUser mobileLogin(@RequestBody LoginRequest request){
        PushNotificationRequest notRequest = new PushNotificationRequest("Test","Test","Test",request.getInstanceId());
        pushNotificationService.sendPushNotification(notRequest);

        return new LoggedInUser("aa@gmail.com","ADMIN");
    }
}