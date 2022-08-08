package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewDao {

    List<Reviews> getAllReviews();

    Reviews getByReviewID(int reviewID);

    Reviews getByDoctorID(Integer doctorID);

    Reviews getByPatientID(Integer patientID);

    Reviews getByOfficeID(Integer officeID);

}
