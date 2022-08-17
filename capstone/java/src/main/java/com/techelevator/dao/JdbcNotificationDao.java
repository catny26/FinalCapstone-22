package com.techelevator.dao;

import com.techelevator.model.Notification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcNotificationDao implements NotificationDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcNotificationDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Notification> findAll() {
        List<Notification> output = new ArrayList<>();
        String sql = "SELECT * FROM notifications;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        while(sqlRowSet.next()){
            output.add(mapRowSetToNotification(sqlRowSet));
        }
        return output;
    }

    @Override
    public List<Notification> getAllNotificationsByUser(long userId) {
        List<Notification> output = new ArrayList<>();
        String sql = "SELECT *" +
                " FROM notifications"+
                " WHERE user_id = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(sqlRowSet.next()){
            output.add(mapRowSetToNotification(sqlRowSet));
        }
        return output;
    }

    @Override
    public List<Notification> getAllNotificationsByAppointment(long appointmentId) {
        List<Notification> output = new ArrayList<>();
        String sql = "SELECT *" +
                " FROM notifications"+
                " WHERE appointment_id = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, appointmentId);
        while(sqlRowSet.next()){
            output.add(mapRowSetToNotification(sqlRowSet));
        }
        return output;
    }

    @Override
    public List<Notification> getAllUnreadNotificationsByUser(long userId) {
        List<Notification> output = new ArrayList<>();
        String sql = "SELECT *" +
                " FROM notifications"+
                " WHERE (user_id = ? AND is_read = false);";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while(sqlRowSet.next()){
            output.add(mapRowSetToNotification(sqlRowSet));
        }
        return output;
    }

    @Override
    public Notification getNotification(long notificationId) {
        Notification output = null;
        String sql = "SELECT *" +
                " FROM notifications"+
                " WHERE notification_id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, notificationId);
        if(sqlRowSet.next()){
            output = mapRowSetToNotification(sqlRowSet);
        }
        return output;
    }

    @Override
    public Notification createNotification(Notification notification) {
        String sql = "INSERT INTO notifications (user_id, appointment_id, message, is_read)" +
                " VALUES (?,?,?,?)"+
                " RETURNING notification_id;";
        long id = jdbcTemplate.queryForObject(sql, Long.class, notification.getUserId(), notification.getAppointmentId(), notification.getMessage(), notification.isRead());
        notification.setNotificationId(id);
        return notification;
    }

    @Override
    public boolean updateNotification(Notification notification) {
        String sql = "UPDATE notifications" +
                " SET user_id = ?, appointment_id = ?, message = ?, is_read = ?" +
                " WHERE notification_id = ?;";
        return jdbcTemplate.update(sql, notification.getUserId(), notification.getAppointmentId(), notification.getMessage(), notification.isRead(), notification.getNotificationId()) == 1;
    }

    @Override
    public boolean deleteNotification(long notificationId) {
        String sql = "DELETE FROM notifications" +
                " WHERE notification_id = ?;";
        return jdbcTemplate.update(sql, notificationId) == 1;
    }

    private Notification mapRowSetToNotification(SqlRowSet sqlRowSet){
        Notification output = new Notification();
        output.setNotificationId(sqlRowSet.getLong("notification_id"));
        output.setUserId(sqlRowSet.getLong("user_id"));
        output.setUserId(sqlRowSet.getLong("appointment_id"));
        output.setMessage(sqlRowSet.getString("message"));
        output.setRead(sqlRowSet.getBoolean("is_read"));
        return output;
    }
}
