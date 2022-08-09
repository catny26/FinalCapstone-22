package com.techelevator.dao;

import com.techelevator.model.Appointment;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcAppointmentDaoTest extends BaseDaoTests {

    private static final Appointment APPOINTMENT_1 = new Appointment(1L, 1L, 3L, 1L, LocalTime.of(13,0), LocalTime.of(13, 30), LocalDate.of(2022,8,15), "Confirmed", "Because I feel like it");
    private static final Appointment APPOINTMENT_2 = new Appointment(2L, 2L, 3L, 1L, LocalTime.of(12, 0), LocalTime.of(13, 0), LocalDate.of(2022, 1,1), "Canceled", "Not allowed, Not on new years");
    private static final Appointment APPOINTMENT_3 = new Appointment(3L, 1L, 3L, 1L, LocalTime.of(9,0), LocalTime.of(12,0), LocalDate.of(2022, 5, 17), "Pending", "Early Morning Surgery");
    private static final Appointment APPOINTMENT_4 = new Appointment(4L, 2L, 3L, 1L, LocalTime.of(10, 0), LocalTime.of(14,0), LocalDate.of(2022, 8, 9), "Canceled", "Way too long");
    private static final Appointment APPOINTMENT_5 = new Appointment(5L, 1L, 3L, 1L, LocalTime.of(10, 0), LocalTime.of(14,0), LocalDate.of(2022, 8, 9), "Canceled", "Way too long");
    private static final Appointment APPOINTMENT_6 = new Appointment(1L, 1L, 3L, 1L, LocalTime.of(10, 0), LocalTime.of(14,0), LocalDate.of(2022, 8, 9), "Canceled", "Way too long");

    private static final List<Appointment> GET_APPOINTMENT_BY_PATIENT = new ArrayList<>(Arrays.asList(APPOINTMENT_1, APPOINTMENT_3));
    private static final List<Appointment> GET_APPOINTMENT_BY_DOCTOR = new ArrayList<>(Arrays.asList(APPOINTMENT_1, APPOINTMENT_2, APPOINTMENT_3, APPOINTMENT_4));

    private JdbcAppointmentDao sut;

    @Before
    public void setup(){
        sut = new JdbcAppointmentDao(new JdbcTemplate(dataSource));
    }

    @Test
    public void getAppointmentsByPatient() {
        assertAppointment(GET_APPOINTMENT_BY_PATIENT, sut.getAppointmentsByPatient(1));
    }

    @Test
    public void getAppointmentsByDoctor() {
        assertAppointment(GET_APPOINTMENT_BY_DOCTOR, sut.getAppointmentsByDoctor(3));
    }

    @Test
    public void getAppointmentById() {
        assertAppointment(APPOINTMENT_1, sut.getAppointmentById(1));
    }

    @Test
    public void createAppointment() {
        assertAppointment(APPOINTMENT_5,sut.createAppointment(APPOINTMENT_5));
    }

    @Test
    public void updateAppointment() {
        sut.updateAppointment(APPOINTMENT_6);
        assertAppointment(APPOINTMENT_6, sut.getAppointmentById(1));
    }

    private void assertAppointment(List<Appointment> expected, List<Appointment> actual){
        for(int i = 0; i < actual.size(); i++){
            assertAppointment(expected.get(i), actual.get(i));
        }
    }

    private void assertAppointment(Appointment expected, Appointment actual){
        assertEquals(expected.getId(), actual.getId(), "ID's Don't Match.");
        assertEquals(expected.getPatientId(), actual.getPatientId(), "Patient ID's Don't Match.");
        assertEquals(expected.getDoctorId(), actual.getDoctorId(), "Doctor ID's Don't Match.");
        assertEquals(expected.getAgendaId(), actual.getAgendaId(), "Agenda ID's Don't Match.");
        assertEquals(expected.getStartTime(), actual.getStartTime(), "Start Time's Don't Match.");
        assertEquals(expected.getEndTime(), actual.getEndTime(), "End Time's Don't Match.");
        assertEquals(expected.getDate(), actual.getDate(), "Date's Don't Match");
        assertEquals(expected.getStatus(), actual.getStatus(), "Status' Don't Match.");
        assertEquals(expected.getReason(), actual.getReason(), "Reason's Don't Match.");
    }
}