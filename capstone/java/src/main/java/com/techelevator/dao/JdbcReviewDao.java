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
        List<Reviews> review = new ArrayList<>();
        String sql = "SELECT * FROM reviews";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Reviews reviews = mapRowToReview(results);
        }
        return review;
    }

    @Override
    public Reviews getByReviewID(int reviewID) {
        String sql = "SELECT review_id FROM reviews WHERE review_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewID);
        if(results.next()){
            return mapRowToReview(results);
        }
        return reviewID;

    }

    @Override
    public Reviews getByDoctorID(Integer doctorID) {
        String sql = "SELECT * " +
                    "FROM reviews r " +
                    "JOIN users u " +
                    "ON r.doctor_id = u.user_id " +
                    "WHERE r.doctor_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorID);
        if(results.next()){
            return mapRowToReview(results);
        }
        return doctorID;
    }

    @Override
    public Reviews getByPatientID(Integer patientID) {
        String sql = "SELECT * " +
                    "FROM reviews r " +
                    "JOIN users u " +
                    "ON r.patient_id = u.user_id " +
                    "WHERE r.patient_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientID);
        if(results.next()){
            return mapRowToReview(results);
        }
        return patientID;
    }

    @Override
    public Reviews getByOfficeID(Integer officeID) {
        String sql = "SELECT * " +
                    "FROM office_info i " +
                    "JOIN reviews r " +
                    "ON i.office_id = r.office_id " +
                    "WHERE r.office_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeID);
        if(results.next()){
            return mapRowToReview(results);
        }
        return officeID;
    }

    public Reviews(){

    }

    private Reviews mapRowToReview(SqlRowSet results) {
        Reviews review = new Reviews();
        review.setReviewID(results.getInt("review_id"));
        review.setDoctorID(results.getInt("doctor_id"));
        review.setPatientID(results.getInt("patient_id"));
        review.setOfficeID(results.getInt("office_id"));
    }
}
