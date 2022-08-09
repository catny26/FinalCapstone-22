package com.techelevator.dao;

import com.techelevator.model.Reviews;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcReviewDao implements ReviewDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Reviews> getAllReviews() {
        List<Reviews> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Reviews review = mapRowToReview(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public Reviews getByReviewID(long reviewID) {
        String sql = "SELECT * FROM reviews WHERE review_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewID);
        if(results.next()){
            return mapRowToReview(results);
        }
        return null;

    }

    @Override
    public Reviews getByDoctorID(long doctorID) {
        String sql = "SELECT r.review_id, r.amount_of_stars, r.review_message, r.doctor_id, r.patient_id, r.review_response, r.office_id " +
                    "FROM reviews r " +
                    "WHERE r.doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorID);
        if(results.next()){
            return mapRowToReview(results);
        }
        return null;
    }

    @Override
    public Reviews getByPatientID(long patientID) {
        String sql = "SELECT r.review_id, r.amount_of_stars, r.review_message, r.doctor_id, r.patient_id, r.office_id " +
                    "FROM reviews r " +
                    "WHERE r.patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientID);
        if(results.next()){
            return mapRowToReview(results);
        }
        return null;
    }

    @Override
    public Reviews getByOfficeID(long officeID) {
        String sql = "SELECT review_id, amount_of_stars, review_message, doctor_id, patient_id, office_id " +
                    "FROM reviews " +
                    "WHERE office_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeID);
        if(results.next()){
            return mapRowToReview(results);
        }
        return null;
    }

    @Override
    public Reviews createReview(Reviews reviews) {
        String sql = "INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response);" +
                    " VALUES (?,?,?,?,?,?);" +
                    " RETURNING review_id;";
        long id = jdbcTemplate.queryForObject(sql, Long.class, reviews.getAmountOfStars(), reviews.getReviewMessage(), reviews.getDoctorID(), reviews.getPatientID(), reviews.getOfficeID());
        return reviews;
    }


    private Reviews mapRowToReview(SqlRowSet results) {
        Reviews review = new Reviews();
        review.setAmountOfStars(results.getInt("amount_of_stars"));
        review.setReviewMessage(results.getString("review_message"));
        review.setDoctorID(results.getLong("doctor_id"));
        review.setPatientID(results.getLong("patient_id"));
        review.setOfficeID(results.getLong("office_id"));
        review.setReviewResponse(results.getString("review_response"));
        return new Reviews();
    }
}
