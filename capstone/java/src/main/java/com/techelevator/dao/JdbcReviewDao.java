package com.techelevator.dao;

import com.techelevator.model.Reviews;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate((dataSource));
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
    public List<Reviews> getByDoctorID(long doctorID) {
        List<Reviews> output = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorID);
        while(results.next()){
            output.add(mapRowToReview(results));
        }
        return output;
    }

    @Override
    public List<Reviews> getByPatientID(long patientID) {
        List<Reviews> output = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientID);
        while(results.next()){
            output.add(mapRowToReview(results));
        }
        return output;
    }

    @Override
    public List<Reviews> getByOfficeID(long officeID) {
        List<Reviews> output = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE office_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeID);
        while(results.next()){
            output.add(mapRowToReview(results));
        }
        return output;
    }

    @Override
    public Reviews createReview(Reviews reviews) {
        String sql = "INSERT INTO reviews (amount_of_stars, review_message, doctor_id, patient_id, office_id, review_response)" +
                    " VALUES (?,?,?,?,?,?)" +
                    " RETURNING review_id;";
        long id = jdbcTemplate.queryForObject(sql, Long.class, reviews.getAmountOfStars(), reviews.getReviewMessage(), reviews.getDoctorID(), reviews.getPatientID(), reviews.getOfficeID(), reviews.getReviewResponse());
        reviews.setId(id);
        return reviews;
    }

    @Override
    public void updateReview(long reviewId, Reviews review){
        String sql = "UPDATE reviews " +
                     "SET review_response = ? " +
                     "WHERE review_id = ?;";
        jdbcTemplate.update(sql, reviewId, review.getReviewResponse());
    }

    private Reviews mapRowToReview(SqlRowSet results) {
        Reviews review = new Reviews();
        review.setId(results.getLong("review_id"));
        review.setAmountOfStars(results.getInt("amount_of_stars"));
        review.setReviewMessage(results.getString("review_message"));
        review.setDoctorID(results.getLong("doctor_id"));
        review.setPatientID(results.getLong("patient_id"));
        review.setOfficeID(results.getLong("office_id"));
        review.setReviewResponse(results.getString("review_response"));
        return review;
    }
}
