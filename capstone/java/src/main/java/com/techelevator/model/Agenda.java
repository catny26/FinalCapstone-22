package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class Agenda {

    private long agendaId;
    private long doctorId;
    private Integer[] mon;
    private Integer[] tue;
    private Integer[] wen;
    private Integer[] thur;
    private Integer[] fri;
    private Integer[] sat;
    private Integer[] sun;

    public Agenda(){}

    public Agenda(long agendaId, long doctorId, Integer[] mon, Integer[] tue, Integer[] wen, Integer[] thur, Integer[] fri, Integer[] sat, Integer[] sun) {
        this.agendaId = agendaId;
        this.doctorId = doctorId;
        this.mon = mon;
        this.tue = tue;
        this.wen = wen;
        this.thur = thur;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
    }

    public Agenda(long agendaId, long doctorId) {
        this.agendaId = agendaId;
        this.doctorId = doctorId;
    }

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

    public Integer[] getMon() {
        return mon;
    }

    public void setMon(Integer[] mon) {
        this.mon = mon;
    }

    public Integer[] getTue() {
        return tue;
    }

    public void setTue(Integer[] tue) {
        this.tue = tue;
    }

    public Integer[] getWen() {
        return wen;
    }

    public void setWen(Integer[] wen) {
        this.wen = wen;
    }

    public Integer[] getThur() {
        return thur;
    }

    public void setThur(Integer[] thur) {
        this.thur = thur;
    }

    public Integer[] getFri() {
        return fri;
    }

    public void setFri(Integer[] fri) {
        this.fri = fri;
    }

    public Integer[] getSat() {
        return sat;
    }

    public void setSat(Integer[] sat) {
        this.sat = sat;
    }

    public Integer[] getSun() {
        return sun;
    }

    public void setSun(Integer[] sun) {
        this.sun = sun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return agendaId == agenda.agendaId && doctorId == agenda.doctorId && Arrays.equals(mon, agenda.mon) && Arrays.equals(tue, agenda.tue) && Arrays.equals(wen, agenda.wen) && Arrays.equals(thur, agenda.thur) && Arrays.equals(fri, agenda.fri) && Arrays.equals(sat, agenda.sat) && Arrays.equals(sun, agenda.sun);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(agendaId, doctorId);
        result = 31 * result + Arrays.hashCode(mon);
        result = 31 * result + Arrays.hashCode(tue);
        result = 31 * result + Arrays.hashCode(wen);
        result = 31 * result + Arrays.hashCode(thur);
        result = 31 * result + Arrays.hashCode(fri);
        result = 31 * result + Arrays.hashCode(sat);
        result = 31 * result + Arrays.hashCode(sun);
        return result;
    }
}
