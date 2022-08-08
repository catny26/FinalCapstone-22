package com.techelevator.model;

public class Reviews {

    private int reviewID;
    private int amountOfStars;
    private char reviewMessage;
    private Integer doctorID;
    private Integer patientID;
    private Integer officeID;
    private char reviewResponse;

    public Reviews(int reviewID, int amountOfStars, char reviewMessage, Integer doctorID, Integer patientID, Integer officeID, char reviewResponse) {
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

    public char getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(char reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public Integer getOfficeID() {
        return officeID;
    }

    public void setOfficeID(Integer officeID) {
        this.officeID = officeID;
    }

    public char getReviewResponse() {
        return reviewResponse;
    }

    public void setReviewResponse(char reviewResponse) {
        this.reviewResponse = reviewResponse;
    }
}
