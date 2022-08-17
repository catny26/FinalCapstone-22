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
//
//    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
//
//    private final Agenda AGENDA_1 = new Agenda(1, 3, LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), null, null, null, null, LocalTime.parse("12:00", dtf), LocalTime.parse("13:00", dtf));
//    private final Agenda AGENDA_2 = new Agenda(2, 3, null, null, null, null, LocalTime.parse("08:00", dtf), LocalTime.parse("16:00", dtf), LocalTime.parse("08:00", dtf), LocalTime.parse("16:00", dtf), LocalTime.parse("08:00", dtf), LocalTime.parse("16:00", dtf), LocalTime.parse("08:00", dtf), LocalTime.parse("16:00", dtf), LocalTime.parse("08:00", dtf), LocalTime.parse("16:00", dtf), LocalTime.parse("11:00", dtf), LocalTime.parse("12:00", dtf));
//    private final Agenda AGENDA_3 = new Agenda(3, 3, LocalTime.parse("09:30", dtf), LocalTime.parse("17:30", dtf), LocalTime.parse("09:30", dtf), LocalTime.parse("17:30", dtf), null, null, null, null, LocalTime.parse("09:30", dtf), LocalTime.parse("17:30", dtf), LocalTime.parse("09:30", dtf), LocalTime.parse("17:30", dtf), LocalTime.parse("09:30", dtf), LocalTime.parse("17:30", dtf), LocalTime.parse("11:30", dtf), LocalTime.parse("12:30", dtf));
//    private final Agenda AGENDA_4 = new Agenda(4, 3, LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), null, null, null, null, LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("12:00", dtf), LocalTime.parse("13:00", dtf));
//
//    private final Agenda AGENDA_5 = new Agenda(5, 3, LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), null, null, null, null, LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("09:00", dtf), LocalTime.parse("17:00", dtf), LocalTime.parse("12:00", dtf), LocalTime.parse("13:00", dtf));
//    private final Agenda AGENDA_6 = new Agenda(1, 3, null, null, null, null, LocalTime.parse("08:00", dtf), LocalTime.parse("16:00", dtf), LocalTime.parse("08:00", dtf), LocalTime.parse("16:00", dtf), LocalTime.parse("08:00", dtf), LocalTime.parse("16:00", dtf), LocalTime.parse("08:00", dtf), LocalTime.parse("16:00", dtf), LocalTime.parse("08:00", dtf), LocalTime.parse("16:00", dtf), LocalTime.parse("11:00", dtf), LocalTime.parse("12:00", dtf));
//
//    private final List<Agenda> FIND_ALL = new ArrayList<>(Arrays.asList(AGENDA_1, AGENDA_2, AGENDA_3, AGENDA_4));
//    private final List<Agenda> AGENDAS_BY_DOCTOR = new ArrayList<>(Arrays.asList(AGENDA_1, AGENDA_2, AGENDA_3, AGENDA_4));
//    private final List<Agenda> AGENDAS_BY_AVAILABILITY_MONDAY = new ArrayList<>(Arrays.asList(AGENDA_1, AGENDA_3, AGENDA_4));
//    private final List<Agenda> AGENDAS_BY_AVAILABILITY_SATURDAY = new ArrayList<>(Arrays.asList(AGENDA_2, AGENDA_3, AGENDA_4));
//    private final List<Agenda> AGENDAS_BY_AVAILABILITY_WEDNESDAY = new ArrayList<>(Arrays.asList(AGENDA_1, AGENDA_2, AGENDA_3));
//
//    private JdbcAgendaDao sut;
//
//    @Before
//    public void setup() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        sut = new JdbcAgendaDao(jdbcTemplate);
//    }
//
//    @Test
//    public void findAllTest() {
//        assertMultipleAgendas(FIND_ALL, sut.findAll());
//    }
//
////    @Test
////    public void getAgendasByDoctorIdTest(){
////        assertMultipleAgendas(AGENDAS_BY_DOCTOR, sut.getAgendaByDoctorId(3));
////    }
//
//    @Test
//    public void getAgendasByAvailabilityDayTest() {
//        assertMultipleAgendas(AGENDAS_BY_AVAILABILITY_MONDAY, sut.getAgendasByAvailabilityDay("monday"));
//        assertMultipleAgendas(AGENDAS_BY_AVAILABILITY_SATURDAY, sut.getAgendasByAvailabilityDay("saturday"));
//        assertMultipleAgendas(AGENDAS_BY_AVAILABILITY_WEDNESDAY, sut.getAgendasByAvailabilityDay("wednesday"));
//    }
//
//    @Test
//    public void getAgendaByIdTest() {
//        assertAgenda(AGENDA_4, sut.getAgendaById(4));
//    }
//
//    @Test
//    public void createAgendaTest() {
//        sut.createAgenda(AGENDA_5);
//        assertAgenda(AGENDA_5, sut.getAgendaById(5));
//    }
//
//    @Test
//    public void updateAgendaTest(){
//        sut.updateAgenda(AGENDA_6);
//        assertAgenda(AGENDA_6, sut.getAgendaById(1));
//    }
//
//
//    private void assertAgenda(Agenda expected, Agenda actual) {
//        assertEquals(expected.getAgendaId(), actual.getAgendaId(), "Agenda ID's do not match");
//        assertEquals(expected.getDoctorId(), actual.getDoctorId(), "Doctor ID's do not match");
//        assertEquals(expected.getMonStart(), actual.getMonStart(), "Monday Start time does not match");
//        assertEquals(expected.getMonEnd(), actual.getMonEnd(), "Monday End time does not match");
//        assertEquals(expected.getTueStart(), actual.getTueStart(), "Tuesday Start time does not match");
//        assertEquals(expected.getTueEnd(), actual.getTueEnd(), "Tuesday End time does not match");
//        assertEquals(expected.getWenStart(), actual.getWenStart(), "Wednesday Start time does not match");
//        assertEquals(expected.getWenEnd(), actual.getWenEnd(), "Wednesday End time does not match");
//        assertEquals(expected.getThurStart(), actual.getThurStart(), "Thursday Start time does not match");
//        assertEquals(expected.getThurEnd(), actual.getThurEnd(), "Thursday End time does not match");
//        assertEquals(expected.getFriStart(), actual.getFriStart(), "Friday Start time does not match");
//        assertEquals(expected.getFriEnd(), actual.getFriEnd(), "Friday End time does not match");
//        assertEquals(expected.getSatStart(), actual.getSatStart(), "Saturday Start time does not match");
//        assertEquals(expected.getSatEnd(), actual.getSatEnd(), "Saturday End time does not match");
//        assertEquals(expected.getSunStart(), actual.getSunStart(), "Sunday Start time does not match");
//        assertEquals(expected.getSunEnd(), actual.getSunEnd(), "Sunday End time does not match");
//        assertEquals(expected.getLunchStart(), actual.getLunchStart(), "Lunch Start time does not match");
//        assertEquals(expected.getLunchEnd(), actual.getLunchEnd(), "Lunch End time does not match");
//    }
//
//    private void assertMultipleAgendas(List<Agenda> expected, List<Agenda> actual) {
//        for (int i = 0; i < actual.size(); i++) {
//            assertAgenda(expected.get(i), actual.get(i));
//        }
//    }
}
