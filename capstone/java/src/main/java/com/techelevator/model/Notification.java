package com.techelevator.model;

import java.util.Objects;

public class Notification {

    private long notificationId;
    private long userId;
    private long appointmentId;
    private String message;
    private boolean isRead;

    public Notification(){};

    public Notification(long notificationId, long userId, long appointmentId, String message, boolean isRead) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.appointmentId = appointmentId;
        this.message = message;
        this.isRead = isRead;
    }

    public long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(long notificationId) {
        this.notificationId = notificationId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
