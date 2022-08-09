package com.techelevator.model;

public class Reviews {

    private long id;
    private int amountOfStars;
    private String reviewMessage;
    private long doctorID;
    private long patientID;
    private long officeID;
    private String reviewResponse;

    public Reviews(long id,int amountOfStars, String reviewMessage, long doctorID, long patientID, long officeID, String reviewResponse) {
        this.id = id;
        this.amountOfStars = amountOfStars;
        this.reviewMessage = reviewMessage;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.officeID = officeID;
        this.reviewResponse = reviewResponse;
    }

    public Reviews() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
