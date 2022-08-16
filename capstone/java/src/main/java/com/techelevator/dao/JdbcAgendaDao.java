package com.techelevator.dao;

import com.techelevator.model.Agenda;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAgendaDao implements AgendaDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAgendaDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    private Agenda mapRowSetToAgenda(SqlRowSet sqlRowSet){
        Agenda output = new Agenda();
        output.setAgendaId(sqlRowSet.getLong("agenda_id"));
        output.setDoctorId(sqlRowSet.getLong("doctor_id"));

        if(sqlRowSet.getObject("mon", Integer[].class) != null){
            output.setMon(sqlRowSet.getObject("mon", Integer[].class));
        }
        if(sqlRowSet.getObject("tue", Integer[].class) != null){
            output.setTue(sqlRowSet.getObject("tue", Integer[].class));
        }
        if(sqlRowSet.getObject("wen", Integer[].class) != null){
            output.setWen(sqlRowSet.getObject("wen", Integer[].class));
        }
        if(sqlRowSet.getObject("thur", Integer[].class) != null){
            output.setThur(sqlRowSet.getObject("thur", Integer[].class));
        }
        if(sqlRowSet.getObject("fri", Integer[].class) != null){
            output.setFri(sqlRowSet.getObject("fri", Integer[].class));
        }
        if(sqlRowSet.getObject("sat", Integer[].class) != null){
            output.setSat(sqlRowSet.getObject("sat", Integer[].class));
        }
        if(sqlRowSet.getObject("sun", Integer[].class) != null){
            output.setSun(sqlRowSet.getObject("sun", Integer[].class));
        }

        return output;
    }

    @Override
    public List<Agenda> findAll() {
        List<Agenda> output = new ArrayList<>();
        String sql = "SELECT agenda_id, doctor_id, mon, tue, wen, thur, fri, sat, sun FROM agenda;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        while(sqlRowSet.next()){
            output.add(mapRowSetToAgenda(sqlRowSet));
        }
        return output;
    }

    @Override
    public Agenda getAgendaByDoctorId(long doctorId) {
        Agenda output = new Agenda();
        String sql = "SELECT agenda_id, doctor_id, mon, tue, wen, thur, fri, sat, sun FROM agenda WHERE doctor_id = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, doctorId);
        if(sqlRowSet.next()){
            output = mapRowSetToAgenda(sqlRowSet);
        }
        return output;
    }

    @Override
    public List<Agenda> getAgendasByAvailabilityDay(String day) {
        List<Agenda> output = new ArrayList<>();
        String sql = "SELECT agenda_id, doctor_id, mon, tue, wen, thur, fri, sat, sun FROM agenda ";
        switch(day.toLowerCase()){
            case "mon":
                sql += "WHERE mon IS NOT NULL;";
                break;
            case "tue":
                sql += "WHERE tue IS NOT NULL;";
                break;
            case "wen":
                sql += "WHERE wen IS NOT NULL;";
                break;
            case "thur":
                sql += "WHERE thur IS NOT NULL;";
                break;
            case "fri":
                sql += "WHERE fri IS NOT NULL;";
                break;
            case "sat":
                sql += "WHERE sat IS NOT NULL;";
                break;
            case "sun":
                sql += "WHERE sun IS NOT NULL;";
                break;
        }
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        while(sqlRowSet.next()){
            output.add(mapRowSetToAgenda(sqlRowSet));
        }
        return output;
    }

    @Override
    public List<Integer> getUnavailableDays(long doctorId) {
        //Monday = 1, Sunday = 7
        List<Integer> output = new ArrayList<>();
        Agenda agenda = new Agenda();
        String sql = "SELECT agenda_id, doctor_id, mon, tue, wen, thur, fri, sat, sun FROM agenda WHERE doctor_id = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        if(sqlRowSet.next()){
            agenda = mapRowSetToAgenda(sqlRowSet);
        }

        if(agenda.getMon() == null){
            output.add(1);
        }
        if(agenda.getTue() == null){
            output.add(2);
        }
        if(agenda.getWen() == null){
            output.add(3);
        }
        if(agenda.getThur() == null){
            output.add(4);
        }
        if(agenda.getFri() == null){
            output.add(5);
        }
        if(agenda.getSat() == null){
            output.add(6);
        }
        if(agenda.getSun() == null){
            output.add(7);
        }

        return output;
    }

    @Override
    public Agenda getAgendaById(long agendaId) {
        Agenda output = new Agenda();
        String sql = "SELECT agenda_id, doctor_id, mon, tue, wen, thur, fri, sat, sun FROM agenda WHERE agenda_id = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, agendaId);
        if(sqlRowSet.next()){
            output = mapRowSetToAgenda(sqlRowSet);
        }
        return output;
    }

    @Override
    public Agenda createAgenda(Agenda agenda) {
        String sql = "INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (?,?,?,?,?,?,?,?) RETURNING agenda_id;";
        long agendaId = jdbcTemplate.update(sql, agenda.getDoctorId(), agenda.getMon(), agenda.getTue(), agenda.getWen(), agenda.getThur(), agenda.getFri(), agenda.getSat(), agenda.getSun());
        agenda.setAgendaId(agendaId);
        return agenda;
    }

    @Override
    public boolean updateAgenda(Agenda agenda) {
        String sql = "UPDATE agenda SET doctor_id = ?, mon = ?, tue = ?, wen = ?, thur = ?, fri = ?, sat = ?, sun = ? WHERE agenda_id = ?;";
        return (jdbcTemplate.update(sql, agenda.getDoctorId(), agenda.getMon(), agenda.getTue(), agenda.getWen(), agenda.getThur(), agenda.getFri(), agenda.getSat(), agenda.getSun(), agenda.getAgendaId())) == 1;

    }

    @Override
    public boolean deleteAgenda(long agendaId) {
        String sql = "DELETE FROM agenda WHERE agenda_id = ?";
        return (jdbcTemplate.update(sql, agendaId) == 1);
    }
}
