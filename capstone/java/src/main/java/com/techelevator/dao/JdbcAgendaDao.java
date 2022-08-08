package com.techelevator.dao;

import com.techelevator.model.Agenda;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcAgendaDao implements AgendaDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAgendaDao(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<Agenda> findAll() {
        List<Agenda> output = new ArrayList<>();
        String sql = "SELECT agenda_id, doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end"+
                " FROM agenda;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        while(sqlRowSet.next()){
            output.add(mapRowSetToAgenda(sqlRowSet));
        }
        return output;
    }

    @Override
    public List<Agenda> getAgendasByDoctorId(long doctorId) {
        List<Agenda> output = new ArrayList<>();
        String sql = "SELECT agenda_id, doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end"+
                " FROM agenda"+
                " WHERE doctor_id = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, doctorId);
        while(sqlRowSet.next()){
            output.add(mapRowSetToAgenda(sqlRowSet));
        }
        return output;
    }

    @Override
    public List<Agenda> getAgendasByAvalabilityDay(String day) {
        List<Agenda> output = new ArrayList<>();
        String sql = "SELECT agenda_id, doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end"+
                " FROM agenda";
        switch(day.toLowerCase()){
            case "monday":
               sql += " WHERE mon_start IS NOT NULL AND mon_end IS NOT NULL;";
               break;
            case "tues":
                sql += " WHERE tue_start IS NOT NULL AND tue_end IS NOT NULL;";
                break;
            case "wednesday":
                sql += " WHERE wen_start IS NOT NULL AND wen_end IS NOT NULL;";
                break;
            case "thursday":
                sql += " WHERE thur_start IS NOT NULL AND thur_end IS NOT NULL;";
                break;
            case "friday":
                sql += " WHERE fri_start IS NOT NULL AND fri_end IS NOT NULL;";
                break;
            case "saturday":
                sql += " WHERE sat_start IS NOT NULL AND sat_end IS NOT NULL;";
                break;
            case "sunday":
                sql += " WHERE sun_start IS NOT NULL AND sun_end IS NOT NULL;";
                break;
        }
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        while(sqlRowSet.next()){
            output.add(mapRowSetToAgenda(sqlRowSet));
        }
        return output;
    }

    @Override
    public Agenda getAgendaById(long agendaId) {
        Agenda output = new Agenda();
        String sql = "SELECT agenda_id, doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end"+
                " FROM agenda"+
                " WHERE agenda_id = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, agendaId);
        if(sqlRowSet.next()){
            output = mapRowSetToAgenda(sqlRowSet);
        }
        return output;
    }

    @Override
    public boolean createAgenda(Agenda agenda) {
        String sql = "INSERT INTO agenda (agenda_id, doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        return jdbcTemplate.update(sql, agenda.getAgendaId(), agenda.getDoctorId(), agenda.getMonStart(), agenda.getMonEnd(), agenda.getTueStart(), agenda.getTueEnd(), agenda.getWenStart(), agenda.getWenEnd(), agenda.getThurStart(), agenda.getThurEnd(), agenda.getFriStart(), agenda.getFriEnd(), agenda.getSatStart(), agenda.getSatEnd(), agenda.getSunStart(), agenda.getSunEnd(), agenda.getLunchStart(), agenda.getLunchEnd()) == 1;
    }

    @Override
    public boolean updateAgenda(Agenda agenda) {
        String sql = "UPDATE agenda"+
                " SET doctor_id = ?, mon_start = ?, mon_end = ?, tue_start = ?, tue_end = ?, wen_start = ?, wen_end = ?, thur_start = ?, thur_end = ?, fri_start = ?, fri_end = ?, sat_start = ?, sat_end - ?, sun_start - ?, sun_end = ?, lunch_start = ?, lunch_end = ?"+
                " WHERE agenda_id =?;";
        return jdbcTemplate.update(sql, agenda.getDoctorId(), agenda.getMonStart(), agenda.getMonEnd(), agenda.getTueStart(), agenda.getTueEnd(), agenda.getWenStart(), agenda.getWenEnd(), agenda.getThurStart(), agenda.getThurEnd(), agenda.getFriStart(), agenda.getFriEnd(), agenda.getSatStart(), agenda.getSatEnd(), agenda.getSunStart(), agenda.getSunEnd(), agenda.getLunchStart(), agenda.getLunchEnd(), agenda.getAgendaId()) == 1;
    }

    @Override
    public boolean deleteAgenda(long agendaId) {
        String sql = "DELETE FROM agenda" +
                " WHERE agenda_id = ?;";
        return jdbcTemplate.update(sql, agendaId) == 1;
    }

    private Agenda mapRowSetToAgenda(SqlRowSet sqlRowSet){
        Agenda output = new Agenda();
        output.setAgendaId(sqlRowSet.getLong("agenda_id"));
        output.setDoctorId(sqlRowSet.getLong("doctor_id"));

        if(sqlRowSet.getTime("mon_start")!= null) {
            output.setMonStart((sqlRowSet.getTime("mon_start").toLocalTime()));
        }
        if(sqlRowSet.getTime("mon_end")!= null) {
            output.setMonEnd((sqlRowSet.getTime("mon_end").toLocalTime()));
        }

        if(sqlRowSet.getTime("tue_start")!= null) {
            output.setTueStart((sqlRowSet.getTime("tue_start").toLocalTime()));
        }
        if(sqlRowSet.getTime("tue_end")!= null) {
            output.setTueEnd((sqlRowSet.getTime("tue_end").toLocalTime()));
        }

        if(sqlRowSet.getTime("wen_start")!= null) {
            output.setWenStart((sqlRowSet.getTime("wen_start").toLocalTime()));
        }
        if(sqlRowSet.getTime("wen_end")!= null) {
            output.setWenEnd((sqlRowSet.getTime("wen_end").toLocalTime()));
        }

        if(sqlRowSet.getTime("thur_start")!= null) {
            output.setThurStart((sqlRowSet.getTime("thur_start").toLocalTime()));
        }
        if(sqlRowSet.getTime("thur_end")!= null) {
            output.setThurEnd((sqlRowSet.getTime("thur_end").toLocalTime()));
        }

        if(sqlRowSet.getTime("fri_start")!= null) {
            output.setFriStart((sqlRowSet.getTime("fri_start").toLocalTime()));
        }
        if(sqlRowSet.getTime("fri_end")!= null) {
            output.setFriEnd((sqlRowSet.getTime("fri_end").toLocalTime()));
        }

        if(sqlRowSet.getTime("sat_start")!= null) {
            output.setSatStart((sqlRowSet.getTime("sat_start").toLocalTime()));
        }
        if(sqlRowSet.getTime("sat_end")!= null) {
            output.setSatEnd((sqlRowSet.getTime("sat_end").toLocalTime()));
        }

        if(sqlRowSet.getTime("sun_start")!= null) {
            output.setSunStart((sqlRowSet.getTime("sun_start").toLocalTime()));
        }
        if(sqlRowSet.getTime("sun_end")!= null) {
            output.setSunEnd((sqlRowSet.getTime("sun_end").toLocalTime()));
        }

        if(sqlRowSet.getTime("lunch_start")!= null) {
            output.setLunchStart((sqlRowSet.getTime("lunch_start").toLocalTime()));
        }
        if(sqlRowSet.getTime("lunch_end")!= null) {
            output.setLunchEnd((sqlRowSet.getTime("lunch_end").toLocalTime()));
        }
        return output;
    }
}
