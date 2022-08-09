package com.techelevator.dao;

import com.techelevator.model.Reviews;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JdbcReviewDaoTests extends BaseDaoTests{

    private final Reviews REVIEW_1 = new Reviews (1,4, "He listens!", 3, 1, 1, null);
    private final Reviews REVIEW_2 = new Reviews (2,5, "I love seeing this doctor", 3, 2, 1, "Thanks, Gina!");
    private final Reviews REVIEW_3 = new Reviews (3,5, "Dr. Mercier has been extremely helpful.", 3, 1, 1, "Thank you, Olivia!");
    private final Reviews REVIEW_4 = new Reviews (4,4, "Good doctor.", 3, 2, 2, "Thank you!");

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
        List<Reviews> reviews = sut.getByDoctorID(3);
        assertReviewsMatch(REVIEW_1, reviews.get(0));
        assertReviewsMatch(REVIEW_2, reviews.get(1));
        assertReviewsMatch(REVIEW_3, reviews.get(2));
        assertReviewsMatch(REVIEW_4, reviews.get(3));
    }

    @Test
    public void getReviewsByPatientID(){
        List<Reviews> reviews = sut.getByPatientID(1);
        assertReviewsMatch(REVIEW_1, reviews.get(0));
        assertReviewsMatch(REVIEW_3, reviews.get(1));
    }

    @Test
    public void getReviewsByOfficeID(){
        List<Reviews> output = sut.getByOfficeID(1);

        assertReviewsMatch(REVIEW_1, output.get(0));
        assertReviewsMatch(REVIEW_2, output.get(1));
        assertReviewsMatch(REVIEW_3, output.get(2));
    }

    @Test
    public void returnsNullWhenReviewNotFound(){
        Reviews reviews = sut.getByReviewID(99);
        Assert.assertNull(reviews);
    }

    private void assertReviewsMatch(Reviews expected, Reviews actual){
        assertEquals(expected.getAmountOfStars(), actual.getAmountOfStars(), "Amount of Star's Don't Match");
        assertEquals(expected.getReviewMessage(), actual.getReviewMessage(), "Review Message's Don't Match");
        assertEquals(expected.getDoctorID(), actual.getDoctorID(), "Doctor ID's Don't Match.");
        assertEquals(expected.getPatientID(), actual.getPatientID(), "Patient ID's Don't Match.");
        assertEquals(expected.getOfficeID(), actual.getOfficeID(), "Office ID's Don't Match.");
        assertEquals(expected.getReviewResponse(), actual.getReviewResponse(), "Review Responses Don't Match.");
    }

}
