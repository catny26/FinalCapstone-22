package com.techelevator.dao;

import com.techelevator.model.Agenda;

import java.util.List;

public interface AgendaDao {

    List<Agenda> findAll();

    List<Agenda> getAgendasByDoctorId(long doctorId);

    List<Agenda> getAgendasByAvailabilityDay(String day);

    List<Integer> getUnavailableDays(long doctorId);

    Agenda getAgendaById(long agendaId);

    Agenda createAgenda(Agenda agenda);

    boolean updateAgenda(Agenda agenda);

    boolean deleteAgenda(long agendaId);

}
