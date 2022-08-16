package com.techelevator.dao;

import com.techelevator.model.Agenda;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JdbcAgendaDaoTests extends BaseDaoTests {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

    private static final Agenda AGENDA_1 = new Agenda(1, 1, new Integer[]{8,9,10,11,13,14,15,16,17}, new Integer[]{8,9,10,11,13,14,15,16,17}, new Integer[]{8,9,10,11,13,14,15,16,17},new Integer[]{8,9,10,11,13,14,15,16,17},new Integer[]{8,9,10,11,13,14,15,16,17}, null, null);
    private static final Agenda AGENDA_2 = new Agenda(2, 2, new Integer[]{8,9,10,11,13,14,15,16,17}, new Integer[]{8,9,10,11,13,14,15,16,17}, new Integer[]{8,9,10,11,13,14,15,16,17}, null, null, new Integer[]{8,9,10,11,13,14,15,16,17}, new Integer[]{8,9,10,11,13,14,15,16,17});
    private static final Agenda AGENDA_3 = new Agenda(3, 3, new Integer[]{8,9,10,11,13,14,15,16,17}, null, null, new Integer[]{8,9,10,11,13,14,15,16,17}, new Integer[]{8,9,10,11,13,14,15,16,17}, new Integer[]{8,9,10,11,13,14,15,16,17}, new Integer[]{8,9,10,11,13,14,15,16,17});
    private static final Agenda AGENDA_4 = new Agenda(4, 4, null, null, null, null, null, null, null);
    private static final Agenda AGENDA_5 = new Agenda(1, 4, null, null, null, null, null, null, null);


    private static final List<Agenda> FIND_ALL = new ArrayList<>(Arrays.asList(AGENDA_1, AGENDA_2, AGENDA_3));
    private static final List<Agenda> AGENDAS_BY_AVAILABILITY_MONDAY = FIND_ALL;
    private static final List<Agenda> AGENDAS_BY_AVAILABILITY_SATURDAY = new ArrayList<>(Arrays.asList(AGENDA_2, AGENDA_3));
    private static final List<Agenda> AGENDAS_BY_AVAILABILITY_WEDNESDAY = new ArrayList<>(Arrays.asList(AGENDA_1, AGENDA_2));

    private JdbcAgendaDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcAgendaDao(jdbcTemplate);
    }

    @Test
    public void findAllTest() {
        assertMultipleAgendas(FIND_ALL, sut.findAll());
    }

//    @Test
//    public void getAgendasByDoctorIdTest(){
//        assertMultipleAgendas(AGENDAS_BY_DOCTOR, sut.getAgendaByDoctorId(3));
//    }

    @Test
    public void getAgendasByAvailabilityDayTest() {
        assertMultipleAgendas(AGENDAS_BY_AVAILABILITY_MONDAY, sut.getAgendasByAvailabilityDay("monday"));
        assertMultipleAgendas(AGENDAS_BY_AVAILABILITY_SATURDAY, sut.getAgendasByAvailabilityDay("saturday"));
        assertMultipleAgendas(AGENDAS_BY_AVAILABILITY_WEDNESDAY, sut.getAgendasByAvailabilityDay("wednesday"));
    }

    @Test
    public void getAgendaByIdTest() {
        assertAgenda(AGENDA_1, sut.getAgendaById(1));
    }

    @Test
    public void createAgendaTest() {
        sut.createAgenda(AGENDA_4);
        assertAgenda(AGENDA_4, sut.getAgendaById(5));
    }

    @Test
    public void updateAgendaTest(){
        sut.updateAgenda(AGENDA_5);
        assertAgenda(AGENDA_5, sut.getAgendaById(1));
    }


    private void assertAgenda(Agenda expected, Agenda actual) {
        assertEquals(expected.getAgendaId(), actual.getAgendaId(), "Agenda ID's do not match");
        assertEquals(expected.getDoctorId(), actual.getDoctorId(), "Doctor ID's do not match");

    }

    private void assertMultipleAgendas(List<Agenda> expected, List<Agenda> actual) {
        for (int i = 0; i < actual.size(); i++) {
            assertAgenda(expected.get(i), actual.get(i));
        }
    }
}
