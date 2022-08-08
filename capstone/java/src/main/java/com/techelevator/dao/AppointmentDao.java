package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.util.List;

public interface AppointmentDao {

    public List<Appointment> getAppointmentsByPatient(long patientId);

    public List<Appointment> getAppointmentsByDoctor(long doctorId);

    public Appointment getAppointmentById(long id);

    public Appointment createAppointment(Appointment appointment);

    public Appointment updateAppointment(Appointment appointment);

    public boolean deleteAppointment(long id);

}
