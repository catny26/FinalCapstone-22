package com.techelevator.dao;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcAppointmentDaoTest extends BaseDaoTests {

    private JdbcAppointmentDao sut;

    @Before
    public void setup(){
        sut = new JdbcAppointmentDao(new JdbcTemplate(dataSource));
    }

    @Test
    public void getAppointmentsByPatient() {

    }

    @Test
    public void getAppointmentsByDoctor() {
    }

    @Test
    public void getAppointmentById() {
    }

    @Test
    public void createAppointment() {
    }

    @Test
    public void updateAppointment() {
    }
}