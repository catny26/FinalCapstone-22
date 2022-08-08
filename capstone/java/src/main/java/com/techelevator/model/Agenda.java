package com.techelevator.model;

import java.time.LocalTime;
import java.util.Objects;

public class Agenda {

    private long agendaId;
    private long doctorId;
    private LocalTime monStart;
    private LocalTime monEnd;
    private LocalTime tueStart;
    private LocalTime tueEnd;
    private LocalTime wenStart;
    private LocalTime wenEnd;
    private LocalTime thurStart;
    private LocalTime thurEnd;
    private LocalTime friStart;
    private LocalTime friEnd;
    private LocalTime satStart;
    private LocalTime satEnd;
    private LocalTime sunStart;
    private LocalTime sunEnd;
    private LocalTime lunchStart;
    private LocalTime lunchEnd;

    public long getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(long agendaId) {
        this.agendaId = agendaId;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalTime getMonStart() {
        return monStart;
    }

    public void setMonStart(LocalTime monStart) {
        this.monStart = monStart;
    }

    public LocalTime getMonEnd() {
        return monEnd;
    }

    public void setMonEnd(LocalTime monEnd) {
        this.monEnd = monEnd;
    }

    public LocalTime getTueStart() {
        return tueStart;
    }

    public void setTueStart(LocalTime tueStart) {
        this.tueStart = tueStart;
    }

    public LocalTime getTueEnd() {
        return tueEnd;
    }

    public void setTueEnd(LocalTime tueEnd) {
        this.tueEnd = tueEnd;
    }

    public LocalTime getWenStart() {
        return wenStart;
    }

    public void setWenStart(LocalTime wenStart) {
        this.wenStart = wenStart;
    }

    public LocalTime getWenEnd() {
        return wenEnd;
    }

    public void setWenEnd(LocalTime wenEnd) {
        this.wenEnd = wenEnd;
    }

    public LocalTime getThurStart() {
        return thurStart;
    }

    public void setThurStart(LocalTime thurStart) {
        this.thurStart = thurStart;
    }

    public LocalTime getThurEnd() {
        return thurEnd;
    }

    public void setThurEnd(LocalTime thurEnd) {
        this.thurEnd = thurEnd;
    }

    public LocalTime getFriStart() {
        return friStart;
    }

    public void setFriStart(LocalTime friStart) {
        this.friStart = friStart;
    }

    public LocalTime getFriEnd() {
        return friEnd;
    }

    public void setFriEnd(LocalTime friEnd) {
        this.friEnd = friEnd;
    }

    public LocalTime getSatStart() {
        return satStart;
    }

    public void setSatStart(LocalTime satStart) {
        this.satStart = satStart;
    }

    public LocalTime getSatEnd() {
        return satEnd;
    }

    public void setSatEnd(LocalTime satEnd) {
        this.satEnd = satEnd;
    }

    public LocalTime getSunStart() {
        return sunStart;
    }

    public void setSunStart(LocalTime sunStart) {
        this.sunStart = sunStart;
    }

    public LocalTime getSunEnd() {
        return sunEnd;
    }

    public void setSunEnd(LocalTime sunEnd) {
        this.sunEnd = sunEnd;
    }

    public LocalTime getLunchStart() {
        return lunchStart;
    }

    public void setLunchStart(LocalTime lunchStart) {
        this.lunchStart = lunchStart;
    }

    public LocalTime getLunchEnd() {
        return lunchEnd;
    }

    public void setLunchEnd(LocalTime lunchEnd) {
        this.lunchEnd = lunchEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return agendaId == agenda.agendaId && doctorId == agenda.doctorId && Objects.equals(monStart, agenda.monStart) && Objects.equals(monEnd, agenda.monEnd) && Objects.equals(tueStart, agenda.tueStart) && Objects.equals(tueEnd, agenda.tueEnd) && Objects.equals(wenStart, agenda.wenStart) && Objects.equals(wenEnd, agenda.wenEnd) && Objects.equals(thurStart, agenda.thurStart) && Objects.equals(thurEnd, agenda.thurEnd) && Objects.equals(friStart, agenda.friStart) && Objects.equals(friEnd, agenda.friEnd) && Objects.equals(satStart, agenda.satStart) && Objects.equals(satEnd, agenda.satEnd) && Objects.equals(sunStart, agenda.sunStart) && Objects.equals(sunEnd, agenda.sunEnd) && Objects.equals(lunchStart, agenda.lunchStart) && Objects.equals(lunchEnd, agenda.lunchEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agendaId, doctorId, monStart, monEnd, tueStart, tueEnd, wenStart, wenEnd, thurStart, thurEnd, friStart, friEnd, satStart, satEnd, sunStart, sunEnd, lunchStart, lunchEnd);
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "agendaId=" + agendaId +
                ", doctorId=" + doctorId +
                ", monday =" + monStart + " - " + monEnd +
                ", tuesday =" + tueStart + " - " + tueEnd +
                ", wendsday =" + wenStart + " - " + wenEnd +
                ", thursday =" + thurStart + " - " + thurEnd +
                ", friday =" + friStart + " - " + friEnd +
                ", saturday =" + satStart + " - " + satEnd +
                ", sunday =" + sunStart + " - " + sunEnd +
                ", lunch =" + lunchStart + " - " + lunchEnd +
                '}';
    }
}
