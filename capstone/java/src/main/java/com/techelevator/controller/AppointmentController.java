package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.model.Appointment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class AppointmentController {

    private AppointmentDao appointmentDao;

    public AppointmentController(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @GetMapping("/doctors/{id}/appointments")
    public List<Appointment> getAppointmentsByDoctor(@PathVariable long id) {
        return appointmentDao.getAppointmentsByDoctor(id);
    }

    @GetMapping("/patients/appointments/{id}")
    public List<Appointment> getAppointmentsByUser(@PathVariable long id) {
        return appointmentDao.getAppointmentsByPatient(id);
    }

    @PostMapping("appointments/")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment createAppointment(@RequestBody Appointment newAppointment) {
        return appointmentDao.createAppointment(newAppointment);
    }

    @PutMapping("patients/{id}/appointments/{appointmentId}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment updateAppointment(@PathVariable("id") long id, @PathVariable("appointmentId") long appointmentId, @RequestBody Appointment updatedAppointment) {
        updatedAppointment.setId(appointmentId);
        if (appointmentDao.updateAppointment(updatedAppointment) != null){
            return updatedAppointment;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Something went wrong! Please try again.");
        }
    }
}
