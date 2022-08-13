package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewDao {

    List<Reviews> getAllReviews();

    Reviews getByReviewID(long reviewID);

    List<Reviews> getByDoctorID(long doctorID);

    List<Reviews> getByPatientID(long patientID);

    List<Reviews> getByOfficeID(long officeID);

    Reviews createReview(Reviews reviews);

    void updateReview(long reviewId, Reviews reviews);
}
