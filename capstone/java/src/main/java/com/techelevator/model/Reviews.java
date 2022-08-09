package com.techelevator.model;

public class Reviews {

    private int reviewID;
    private int amountOfStars;
    private String reviewMessage;
    private long doctorID;
    private long patientID;
    private long officeID;
    private String reviewResponse;

    public Reviews(int reviewID, int amountOfStars, String reviewMessage, long doctorID, long patientID, long officeID, String reviewResponse) {
        this.reviewID = reviewID;
        this.amountOfStars = amountOfStars;
        this.reviewMessage = reviewMessage;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.officeID = officeID;
        this.reviewResponse = reviewResponse;
    }

    public Reviews() {

    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getAmountOfStars() {
        return amountOfStars;
    }

    public void setAmountOfStars(int amountOfStars) {
        this.amountOfStars = amountOfStars;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public long getPatientID() {
        return patientID;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }

    public long getOfficeID() {
        return officeID;
    }

    public void setOfficeID(long officeID) {
        this.officeID = officeID;
    }

    public String getReviewResponse() {
        return reviewResponse;
    }

    public void setReviewResponse(String reviewResponse) {
        this.reviewResponse = reviewResponse;
    }
}
