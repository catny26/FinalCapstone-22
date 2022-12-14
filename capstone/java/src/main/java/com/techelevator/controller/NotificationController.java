package com.techelevator.controller;

import com.techelevator.dao.NotificationDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Notification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class NotificationController {

    private NotificationDao notificationDao;
    private UserDao userDao;

    public NotificationController(NotificationDao notificationDao, UserDao userDao) {
        this.notificationDao = notificationDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/notification", method = RequestMethod.GET)
    public List<Notification> getNotifications() {
        return notificationDao.findAll();
    }

    @RequestMapping(value = "/notification/user/{userId}", method = RequestMethod.GET)
    public List<Notification> getNotificationsByUser(@PathVariable long userId) {
        return notificationDao.getAllNotificationsByUser(userId);
    }

    @RequestMapping(value = "/notification/unread/{userId}", method = RequestMethod.GET)
    public List<Notification> getUnreadNotificationsByUser(@PathVariable long id) {
        return notificationDao.getAllUnreadNotificationsByUser(id);
    }

    @GetMapping("/notification/{appointmentId}")
    public List<Notification> getAllNotificationsByAppointment(@PathVariable long appointmentId) {
        return notificationDao.getAllNotificationsByAppointment(appointmentId);
    }

    @RequestMapping(value = "/notification/{id}", method = RequestMethod.GET)
    public Notification getNotification(@PathVariable long id) throws InterruptedException{
        Thread.sleep(2000);
        return notificationDao.getNotification(id);
    }

    @RequestMapping(value = "/notification/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Notification createNotification(@RequestBody Notification newNotification) {
        return notificationDao.createNotification(newNotification);
    }

    @RequestMapping(value = "/notification/{id}/update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Notification updateNotification(@PathVariable long id, @RequestBody Notification updatedNotification) {
        updatedNotification.setNotificationId(id);
        if(notificationDao.updateNotification(updatedNotification)) {
            return updatedNotification;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification was not updated.");
        }
    }

    @RequestMapping(value = "/notification/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteNotification(@PathVariable long id) {
        if(!notificationDao.deleteNotification(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Your request was unsuccessful. Notification was NOT deleted.");
        }
    }
}
