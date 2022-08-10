package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Notification;
import com.techelevator.model.Reviews;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/user/{id}/reviews", method = RequestMethod.GET)
    public List<Reviews> getReviewsByDoctorID(@PathVariable long doctorID) {
        return reviewDao.getByDoctorID(doctorID);
    }

    @RequestMapping(value = "/user/{id}/reviews", method = RequestMethod.GET)
    public List<Reviews> getReviewsByPatientID(@PathVariable long patientID) {
        return reviewDao.getByPatientID(patientID);
    }

    @RequestMapping(value = "/user/{id}/reviews/{id}", method = RequestMethod.GET)
    public List<Reviews> getReviewsByPatientIDReviewID(@PathVariable long patientID) {
        return reviewDao.getByPatientID(patientID);
    }



}
