package com.techelevator.dao;

import com.techelevator.model.Notification;

import java.util.List;

public interface NotificationDao {

    List<Notification> findAll();

    List<Notification> getAllNotificationsByUser(long userId);

    List<Notification> getAllUnreadNotificationsByUser(long userId);

    List<Notification> getAllNotificationsByAppointment(long appointmentId);

    Notification getNotification(long notificationId);

    Notification createNotification(Notification notification);

    boolean updateNotification(Notification notification);

    boolean deleteNotification(long notificationId);

}
