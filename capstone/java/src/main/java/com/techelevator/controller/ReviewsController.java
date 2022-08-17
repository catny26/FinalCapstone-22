package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Notification;
import com.techelevator.model.Reviews;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//import java.security.Principal;
import java.util.List;

//@PreAuthorize("isAuthenticated()")
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

    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public Reviews getReviewById(@PathVariable long reviewId) {
        return reviewDao.getByReviewID(reviewId);
    }

    @RequestMapping(value = "/reviews/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Reviews createReview(@RequestBody Reviews review) {
        return reviewDao.createReview(review);
    }

    @RequestMapping(value = "/reviews/doctor/{doctorId}", method = RequestMethod.GET)
    public List<Reviews> getReviewsByDoctorID(@PathVariable long doctorId) {
        return reviewDao.getByDoctorID(doctorId);
    }

    @RequestMapping(value = "/reviews/patient/{patientId}", method = RequestMethod.GET)
    public List<Reviews> getReviewsByPatientID(@PathVariable long patientId) {
        return reviewDao.getByPatientID(patientId);
    }

    @RequestMapping(value = "/reviews/{patientId}/{reviewsId}", method = RequestMethod.GET)
    public List<Reviews> getReviewsByPatientIDReviewID(@PathVariable long patientId) {
        return reviewDao.getByPatientID(patientId);
    }
//    //allow original reviewer to update their review, must be authenticated to access specific review/their own review
//    @RequestMapping(value = "/reviews/{patientID}/{reviewID}", method = RequestMethod.PUT)
//    public List<Reviews> updatePatientReview(Principal principal) {
//        return reviewDao.getByPatientID(Long.parseLong(principal.getName()));
//    }
    //allow doctors (only) to reply to reviews
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.PUT)
    public void respondToReviews(@PathVariable long reviewId, @RequestBody Reviews reviews) {
        reviewDao.updateReview(reviewId, reviews);
    }

//    @RequestMapping(path = "whoami")
//    public String whoAmI(Principal principal) {
//        return principal.getName();
//    }



}
