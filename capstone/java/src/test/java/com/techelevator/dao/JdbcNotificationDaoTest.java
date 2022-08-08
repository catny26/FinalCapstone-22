package com.techelevator.dao;

import com.techelevator.model.Notification;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcNotificationDaoTest extends BaseDaoTests {

    private final Notification NOTIFICATION_1 = new Notification(1,1,"HELLO WORLD", false);
    private final Notification NOTIFICATION_2 = new Notification(2,1,"Good Bye", true);
    private final Notification NOTIFICATION_3 = new Notification(3,3,"Your appointment is scheduled for December 25th, 2002", false);
    private final Notification NOTIFICATION_4 = new Notification(4,3,"NO :(", true);

    private final Notification NOTIFICATION_5 = new Notification(5, 2, "New Message", false);
    private final Notification NOTIFICATION_6 = new Notification(1, 3, "UPDATE test", true);

    private final List<Notification> FIND_ALL = new ArrayList<>(Arrays.asList(NOTIFICATION_1, NOTIFICATION_2, NOTIFICATION_3, NOTIFICATION_4));
    private final List<Notification> BY_USER = new ArrayList<>(Arrays.asList(NOTIFICATION_1, NOTIFICATION_2));

    private JdbcNotificationDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcNotificationDao(jdbcTemplate);
    }

    @Test
    public void findAll() {
        assertNotification(FIND_ALL, sut.findAll());
    }

    @Test
    public void getAllNotificationsByUser() {
        assertNotification(BY_USER, sut.getAllNotificationsByUser(1));
    }

    @Test
    public void getAllUnreadNotificationsByUser() {
        assertNotification(Arrays.asList(NOTIFICATION_1), sut.getAllUnreadNotificationsByUser(1));
    }

    @Test
    public void getNotification() {
        assertNotification(NOTIFICATION_1, sut.getNotification(1));
    }

    @Test
    public void createNotification() {
        sut.createNotification(NOTIFICATION_5);
        assertNotification(NOTIFICATION_5, sut.getNotification(5));
    }

    @Test
    public void updateNotification() {
        sut.updateNotification(NOTIFICATION_6);
        assertNotification(NOTIFICATION_6, sut.getNotification(1));
    }

    @Test
    public void deleteNotification() {
        sut.deleteNotification(1);
        assertNull(sut.getNotification(1));
    }

    private void assertNotification(Notification expected, Notification actual){
        assertEquals(expected.getNotificationId(), actual.getNotificationId(), "Notification ID's do not match");
        assertEquals(expected.getUserId(), actual.getUserId(), "User ID's do not match");
        assertEquals(expected.getMessage(), actual.getMessage(), "Messages do not match");
        assertEquals(expected.isRead(), actual.isRead(), "Is Read does not match");
    }

    private void assertNotification(List<Notification> expected, List<Notification> actual){
        for(int i = 0; i < actual.size(); i++){
            assertNotification(expected.get(i), actual.get(i));
        }
    }
}