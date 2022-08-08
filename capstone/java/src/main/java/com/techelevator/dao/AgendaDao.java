package com.techelevator.dao;

import com.techelevator.model.Agenda;

import java.util.List;

public interface AgendaDao {

    List<Agenda> findAll();

    List<Agenda> getAgendasByDoctorId(long doctorId);

    List<Agenda> getAgendasByAvalabilityDay(String day);

    Agenda getAgendaById(long agendaId);

    boolean createAgenda(Agenda agenda);

    boolean updateAgenda(Agenda agenda);

    boolean deleteAgenda(long agendaId);

}
