package com.techelevator.dao;

import com.techelevator.model.Notification;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcNotificationDao implements NotificationDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcNotificationDao(DataSource dataSource){jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<Notification> findAll() {
        return null;
    }

    @Override
    public List<Notification> getAllNotificationsByUser(long userId) {
        return null;
    }

    @Override
    public List<Notification> getAllUnreadNotificationsByUser(long userId) {
        return null;
    }

    @Override
    public Notification getNotification(long notificationId) {
        return null;
    }

    @Override
    public Notification createNotification(Notification notification) {
        return null;
    }

    @Override
    public boolean updateNotification(Notification notification) {
        return false;
    }

    @Override
    public boolean deleteNotification(long notificationId) {
        return false;
    }
}
