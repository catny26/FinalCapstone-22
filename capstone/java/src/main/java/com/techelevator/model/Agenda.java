package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.lang.Nullable;

import java.sql.Array;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Agenda {

    private long agendaId;
    private long doctorId;
    @Nullable
    private List<Integer> mon;
    @Nullable
    private List<Integer> tue;
    @Nullable
    private List<Integer> wen;
    @Nullable
    private List<Integer> thur;
    @Nullable
    private List<Integer> fri;
    @Nullable
    private List<Integer> sat;
    @Nullable
    private List<Integer> sun;

    public Agenda(){}

    public Agenda(long agendaId, long doctorId, List<Integer> mon, List<Integer> tue, List<Integer> wen, List<Integer> thur, List<Integer> fri, List<Integer> sat, List<Integer> sun) {
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

    public List<Integer> getMon() {
        return mon;
    }

    public void setMon(List<Integer> mon) {
        this.mon = mon;
    }

    public List<Integer> getTue() {
        return tue;
    }

    public void setTue(List<Integer> tue) {
        this.tue = tue;
    }

    public List<Integer> getWen() {
        return wen;
    }

    public void setWen(List<Integer> wen) {
        this.wen = wen;
    }

    public List<Integer> getThur() {
        return thur;
    }

    public void setThur(List<Integer> thur) {
        this.thur = thur;
    }

    public List<Integer> getFri() {
        return fri;
    }

    public void setFri(List<Integer> fri) {
        this.fri = fri;
    }

    public List<Integer> getSat() {
        return sat;
    }

    public void setSat(List<Integer> sat) {
        this.sat = sat;
    }

    public List<Integer> getSun() {
        return sun;
    }

    public void setSun(List<Integer> sun) {
        this.sun = sun;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Agenda agenda = (Agenda) o;
//        return agendaId == agenda.agendaId && doctorId == agenda.doctorId && Arrays.equals(mon, agenda.mon) && Arrays.equals(tue, agenda.tue) && Arrays.equals(wen, agenda.wen) && Arrays.equals(thur, agenda.thur) && Arrays.equals(fri, agenda.fri) && Arrays.equals(sat, agenda.sat) && Arrays.equals(sun, agenda.sun);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(agendaId, doctorId);
//        result = 31 * result + Arrays.hashCode(mon);
//        result = 31 * result + Arrays.hashCode(tue);
//        result = 31 * result + Arrays.hashCode(wen);
//        result = 31 * result + Arrays.hashCode(thur);
//        result = 31 * result + Arrays.hashCode(fri);
//        result = 31 * result + Arrays.hashCode(sat);
//        result = 31 * result + Arrays.hashCode(sun);
//        return result;
//    }
}
