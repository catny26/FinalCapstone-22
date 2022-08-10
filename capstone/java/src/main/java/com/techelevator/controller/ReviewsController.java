package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Notification;
import com.techelevator.model.Reviews;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ReviewsController {

    public ReviewDao reviewDao;
    private UserDao userDao;

    public ReviewsController(ReviewDao reviewDao, UserDao userDao){
        this.reviewDao = reviewDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public List<Reviews> getReviews() {
        return reviewDao.getAllReviews();
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Reviews createReview(@RequestBody Reviews review) {
        return reviewDao.createReview(review);
    }

    @RequestMapping(value = "/doctors/{doctorID}/reviews", method = RequestMethod.GET)
    public List<Reviews> getReviewsByDoctorID(@PathVariable long doctorID) {
        return reviewDao.getByDoctorID(doctorID);
    }

    @RequestMapping(value = "/patients/{patientID}/reviews", method = RequestMethod.GET)
    public List<Reviews> getReviewsByPatientID(@PathVariable long patientID) {
        return reviewDao.getByPatientID(patientID);
    }

    @RequestMapping(value = "/user/{patientID}/reviews/{reviewsID}", method = RequestMethod.GET)
    public List<Reviews> getReviewsByPatientIDReviewID(@PathVariable long patientID) {
        return reviewDao.getByPatientID(patientID);
    }
    //allow original reviewer to update their review, must be authenticated to access specific review/their own review
    @RequestMapping(value = "/user/{patientID}/reviews/{reviewID}", method = RequestMethod.PUT)
    public List<Reviews> updatePatientReview(Principal principal) {
        return reviewDao.getByPatientID(Long.parseLong(principal.getName()));
    }
    //allow doctors (only) to reply to reviews
    @RequestMapping(value = "/user/{doctorID}/reviews/{reviewID}", method = RequestMethod.POST)
    public Reviews respondToReviews(@PathVariable long doctorID) {
        return reviewDao.getByReviewID(doctorID);
    }

    @RequestMapping(path = "whoami")
    public String whoAmI(Principal principal) {
        return principal.getName();
    }



}
