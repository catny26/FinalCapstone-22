package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Appointment {

    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long agendaId;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private String status;
    private String reason;

    public Appointment(){}

    public Appointment(Long id, Long patientId, Long doctorId, Long agendaId, LocalTime startTime, LocalTime endTime, LocalDate date, String status, String reason) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.agendaId = agendaId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.status = status;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(Long agendaId) {
        this.agendaId = agendaId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id) && Objects.equals(patientId, that.patientId) && Objects.equals(doctorId, that.doctorId) && Objects.equals(agendaId, that.agendaId) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(date, that.date) && Objects.equals(status, that.status) && Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, doctorId, agendaId, startTime, endTime, date, status, reason);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", agendaId=" + agendaId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
