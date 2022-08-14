package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewDao {

    List<Reviews> getAllReviews();

    Reviews getByReviewID(long reviewId);

    List<Reviews> getByDoctorID(long doctorId);

    List<Reviews> getByPatientID(long patientId);

    List<Reviews> getByOfficeID(long officeId);

    Reviews createReview(Reviews reviews);

    void updateReview(long reviewId, Reviews reviews);


}
