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

    private final Reviews REVIEW_1 = new Reviews (1, 5, "Best medical care ever!", 2003, 4001, 102, "Thank you for your review!");
    private final Reviews REVIEW_2 = new Reviews (2, 5, "Best doctor's visit experience I've had in my LIFE", 2004, 4002, 103, "We appreciate your review!");
    private final Reviews REVIEW_3 = new Reviews (3, 1, "The staff are SO rude! This doc is a hack", 2005, 4003, 104, "We apologize for your negative experience.");
    private final Reviews REVIEW_4 = new Reviews (4, 3, "My appointment took 5 hours for a simple annual, but the customer service was good and my doctor was knowledgable.", 2006, 4004, 105, "Thank you for your review. We will take your review into consideration for future patient visits.");

    private JdbcReviewDao sut;

    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcReviewDao(jdbcTemplate);
    }

    @Test
    public void getAllReviews(){
        List<Reviews> reviews = sut.getAllReviews();

        Assert.assertEquals(3, reviews.size());

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
        Reviews reviews = sut.getByDoctorID(2003);
        assertReviewsMatch(REVIEW_1, reviews);

        reviews = sut.getByDoctorID(2004);
        assertReviewsMatch(REVIEW_2, reviews);

        reviews = sut.getByDoctorID(2005);
        assertReviewsMatch(REVIEW_3, reviews);

        reviews = sut.getByDoctorID(2006);
        assertReviewsMatch(REVIEW_4, reviews);
    }

    @Test
    public void getReviewsByPatientID(){
        Reviews reviews = sut.getByPatientID(4001);
        assertReviewsMatch(REVIEW_1, reviews);

        reviews = sut.getByPatientID(4002);
        assertReviewsMatch(REVIEW_2, reviews);

        reviews = sut.getByPatientID(4003);
        assertReviewsMatch(REVIEW_3, reviews);

        reviews = sut.getByPatientID(4004);
        assertReviewsMatch(REVIEW_4, reviews);
    }

    @Test
    public void getReviewsByOfficeID(){
        Reviews reviews = sut.getByOfficeID(102);
        assertReviewsMatch(REVIEW_1, reviews);

        reviews = sut.getByOfficeID(103);
        assertReviewsMatch(REVIEW_2, reviews);

        reviews = sut.getByOfficeID(104);
        assertReviewsMatch(REVIEW_3, reviews);

        reviews = sut.getByOfficeID(105);
        assertReviewsMatch(REVIEW_4, reviews);
    }

    @Test
    public void returnsNullWhenReviewNotFound(){
        Reviews reviews = sut.getByReviewID(99);
        Assert.assertNull(reviews);
    }

    private void assertReviewsMatch(Reviews expected, Reviews actual){
        Assert.assertEquals(expected.getReviewID(), actual.getReviewID());
        Assert.assertEquals(expected.getReviewMessage(), actual.getReviewMessage());
    }

}
