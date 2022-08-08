package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewDao {

    List<Reviews> getAllReviews();

    Reviews getByReviewID(int reviewID);

    Reviews getByDoctorID(long doctorID);

    Reviews getByPatientID(long patientID);

    Reviews getByOfficeID(long officeID);

}
