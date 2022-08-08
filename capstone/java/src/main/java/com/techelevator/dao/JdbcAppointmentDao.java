package com.techelevator.dao;

import com.techelevator.model.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAppointmentDao implements AppointmentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(long patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT appointment_id, doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, reason FROM appointments WHERE patient_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, patientId);
        while (rowSet.next()) {
            Appointment appointment = mapRowToAppointment(rowSet);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(long doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT appointment_id, doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, reason FROM appointments WHERE doctor_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (rowSet.next()) {
            Appointment appointment = mapRowToAppointment(rowSet);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public Appointment getAppointmentById(long id) {
        String sql = "SELECT appointment_id, doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, reason FROM appointments WHERE appointment_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        if (rowSet.next()) {
            return mapRowToAppointment(rowSet);
        }
        return null;
    }

    @Override
    public Appointment createAppointment(Appointment appointment){
        String sql = "INSERT INTO appointments (doctor_id, patient_id, agenda_id, start_time, end_time, appointment_date, reason) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING appointment_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class, appointment.getDoctorId(), appointment.getPatientId(), appointment.getAgendaId(), appointment.getStartTime(), appointment.getEndTime(), appointment.getDate(), appointment.getReason());
        appointment.setId(newId);

        return appointment;

    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointments SET doctor_id = ?, patient_id = ?, agenda_id = ?, start_time = ?, end_time = ?, appointment_date = ?, reason = ? WHERE appointment_id = ?;";
        jdbcTemplate.update(sql, appointment.getDoctorId(), appointment.getPatientId(), appointment.getAgendaId(), appointment.getStartTime(), appointment.getEndTime(), appointment.getDate(), appointment.getReason(), appointment.getId());

        return getAppointmentById(appointment.getId());
    }

    @Override
    public boolean deleteAppointment(long id) {
        return false;
    }

    private Appointment mapRowToAppointment(SqlRowSet rs) {
        Appointment appointment = new Appointment();
        appointment.setId(rs.getLong("appointment_id"));
        appointment.setDoctorId(rs.getLong("doctor_id"));
        appointment.setPatientId(rs.getLong("patient_id"));
        appointment.setAgendaId(rs.getLong("agenda_id"));
        appointment.setStartTime(rs.getTime("start_time").toLocalTime());
        appointment.setStartTime(rs.getTime("end_time").toLocalTime());
        appointment.setDate(rs.getDate("appointment_date").toLocalDate());
        appointment.setReason(rs.getString("reason"));

        return appointment;
    }
}
