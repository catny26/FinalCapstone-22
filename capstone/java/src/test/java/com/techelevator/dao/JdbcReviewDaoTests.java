package com.techelevator.dao;

import com.techelevator.model.Reviews;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JdbcReviewDaoTests extends BaseDaoTests{

    private final Reviews REVIEW_1 = new Reviews (4, "He listens!", 5, 1, 1, null);
    private final Reviews REVIEW_2 = new Reviews (5, "I love seeing this doctor", 6, 2, 1, "Thanks, Gina!");
    private final Reviews REVIEW_3 = new Reviews (5, "Dr. Mercier has been extremely helpful.", 7, 4, 1, "Thank you, Olivia!");
    private final Reviews REVIEW_4 = new Reviews (4, "Good doctor.", 11, 5, 2, "Thank you!");

    private JdbcReviewDao sut;

    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcReviewDao(jdbcTemplate);
    }

    @Test
    public void getAllReviews(){
        List<Reviews> reviews = sut.getAllReviews();

        Assert.assertEquals(4, reviews.size());

        assertReviewsMatch(REVIEW_1, reviews.get(0));
        assertReviewsMatch(REVIEW_2, reviews.get(1));
        assertReviewsMatch(REVIEW_3, reviews.get(2));
        assertReviewsMatch(REVIEW_4, reviews.get(3));
    }

    @Test
    public void getReviewByID(){
        Reviews reviews = sut.getByReviewID(1);
        assertReviewsMatch(REVIEW_1, reviews);

        reviews = sut.getByReviewID(2);
        assertReviewsMatch(REVIEW_2, reviews);

        reviews = sut.getByReviewID(3);
        assertReviewsMatch(REVIEW_3, reviews);

        reviews = sut.getByReviewID(4);
        assertReviewsMatch(REVIEW_4, reviews);
    }

    @Test
    public void getReviewByDoctorID(){
        Reviews reviews = sut.getByDoctorID(5);
        assertReviewsMatch(REVIEW_1, reviews);

        reviews = sut.getByDoctorID(6);
        assertReviewsMatch(REVIEW_2, reviews);

        reviews = sut.getByDoctorID(7);
        assertReviewsMatch(REVIEW_3, reviews);

        reviews = sut.getByDoctorID(11);
        assertReviewsMatch(REVIEW_4, reviews);
    }

    @Test
    public void getReviewsByPatientID(){
        Reviews reviews = sut.getByPatientID(1);
        assertReviewsMatch(REVIEW_1, reviews);

        reviews = sut.getByPatientID(2);
        assertReviewsMatch(REVIEW_2, reviews);

        reviews = sut.getByPatientID(4);
        assertReviewsMatch(REVIEW_3, reviews);

        reviews = sut.getByPatientID(5);
        assertReviewsMatch(REVIEW_4, reviews);
    }

    @Test
    public void getReviewsByOfficeID(){
        Reviews reviews = sut.getByOfficeID(1);
        assertReviewsMatch(REVIEW_1, reviews);

        reviews = sut.getByOfficeID(1);
        assertReviewsMatch(REVIEW_2, reviews);

        reviews = sut.getByOfficeID(1);
        assertReviewsMatch(REVIEW_3, reviews);

        reviews = sut.getByOfficeID(2);
        assertReviewsMatch(REVIEW_4, reviews);
    }

    @Test
    public void returnsNullWhenReviewNotFound(){
        Reviews reviews = sut.getByReviewID(99);
        Assert.assertNull(reviews);
    }

    private void assertReviewsMatch(Reviews expected, Reviews actual){
        Assert.assertEquals(expected.getReviewMessage(), actual.getReviewMessage());
    }

}
