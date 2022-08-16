package com.techelevator.model;

public class Reviews {

    private long reviewId;
    private int amountOfStars;
    private String reviewMessage;
    private long doctorId;
    private long patientId;
    private long officeId;
    private String reviewResponse;

    public Reviews(long reviewId, int amountOfStars, String reviewMessage, long doctorId, long patientId, long officeId, String reviewResponse) {
        this.reviewId = reviewId;
        this.amountOfStars = amountOfStars;
        this.reviewMessage = reviewMessage;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.officeId = officeId;
        this.reviewResponse = reviewResponse;
    }

    public Reviews() {

    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
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

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public String getReviewResponse() {
        return reviewResponse;
    }

    public void setReviewResponse(String reviewResponse) {
        this.reviewResponse = reviewResponse;
    }
}
