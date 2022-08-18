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
    private Integer[] monArray;
    @Nullable
    private List<Integer> tue;
    @Nullable
    private Integer[] tueArray;
    @Nullable
    private List<Integer> wen;
    @Nullable
    private Integer[] wenArray;
    @Nullable
    private List<Integer> thur;
    @Nullable
    private Integer[] thurArray;
    @Nullable
    private List<Integer> fri;
    @Nullable
    private Integer[] friArray;
    @Nullable
    private List<Integer> sat;
    @Nullable
    private Integer[] satArray;
    @Nullable
    private List<Integer> sun;
    @Nullable
    private Integer[] sunArray;

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

    @Nullable
    public Integer[] getMonArray() {
        return monArray;
    }

    public void setMonArray(@Nullable Integer[] monArray) {
        this.monArray = monArray;
    }

    @Nullable
    public Integer[] getTueArray() {
        return tueArray;
    }

    public void setTueArray(@Nullable Integer[] tueArray) {
        this.tueArray = tueArray;
    }

    @Nullable
    public Integer[] getWenArray() {
        return wenArray;
    }

    public void setWenArray(@Nullable Integer[] wenArray) {
        this.wenArray = wenArray;
    }

    @Nullable
    public Integer[] getThurArray() {
        return thurArray;
    }

    public void setThurArray(@Nullable Integer[] thurArray) {
        this.thurArray = thurArray;
    }

    @Nullable
    public Integer[] getFriArray() {
        return friArray;
    }

    public void setFriArray(@Nullable Integer[] friArray) {
        this.friArray = friArray;
    }

    @Nullable
    public Integer[] getSatArray() {
        return satArray;
    }

    public void setSatArray(@Nullable Integer[] satArray) {
        this.satArray = satArray;
    }

    @Nullable
    public Integer[] getSunArray() {
        return sunArray;
    }

    public void setSunArray(@Nullable Integer[] sunArray) {
        this.sunArray = sunArray;
    }

    public Agenda(long agendaId, long doctorId, @Nullable Integer[] monArray, @Nullable Integer[] tueArray, @Nullable Integer[] wenArray, @Nullable Integer[] thurArray, @Nullable Integer[] friArray, @Nullable Integer[] satArray, @Nullable Integer[] sunArray) {
        this.agendaId = agendaId;
        this.doctorId = doctorId;
        this.monArray = monArray;
        this.tueArray = tueArray;
        this.wenArray = wenArray;
        this.thurArray = thurArray;
        this.friArray = friArray;
        this.satArray = satArray;
        this.sunArray = sunArray;
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
