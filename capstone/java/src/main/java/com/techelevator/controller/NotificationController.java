package com.techelevator.controller;

import com.techelevator.dao.JdbcNotificationDao;
import com.techelevator.dao.NotificationDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Notification;
import org.springframework.data.util.AnnotationDetectionFieldCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/notification/user/{id}", method = RequestMethod.GET)
    public List<Notification> getNotificationsByUser(@PathVariable long id) {
        return notificationDao.getAllNotificationsByUser(id);
    }

    @RequestMapping(value = "/notification/user/{id}/unread", method = RequestMethod.GET)
    public List<Notification> getUnreadNotificationsByUser(@PathVariable long id) {
        return notificationDao.getAllUnreadNotificationsByUser(id);
    }

    @RequestMapping(value = "/notification/{id}", method = RequestMethod.GET)
    public Notification getNotification(@PathVariable long id) {
        return notificationDao.getNotification(id);
    }
}
