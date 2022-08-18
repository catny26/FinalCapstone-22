package com.techelevator.dao;

import com.techelevator.model.Agenda;
import com.techelevator.model.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class JdbcAgendaDao implements AgendaDao {

    private final String FETCH_SQL_BY_ID = "Select * from agenda where doctor_id = ?";

    private final JdbcTemplate jdbcTemplate;

    public JdbcAgendaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Agenda> findAll() {
        return jdbcTemplate.query("SELECT * FROM agenda", new RowMapper<Agenda>() {
            @Override
            public Agenda mapRow(ResultSet resultSet, int i) throws SQLException {
                Agenda agenda = new Agenda();
                agenda.setAgendaId(resultSet.getLong(1));
                agenda.setDoctorId(resultSet.getLong(2));
                if (resultSet.getArray("tue") != null) {
                    agenda.setMon(Arrays.asList((Integer[]) resultSet.getArray("mon").getArray()));
                }
                if (resultSet.getArray("tue") != null) {
                    agenda.setTue(Arrays.asList((Integer[]) resultSet.getArray("tue").getArray()));
                }
                if (resultSet.getArray("wen") != null) {
                    agenda.setWen(Arrays.asList((Integer[]) resultSet.getArray("wen").getArray()));
                }
                if (resultSet.getArray("thur") != null) {
                    agenda.setThur(Arrays.asList((Integer[]) resultSet.getArray("thur").getArray()));
                }
                if (resultSet.getArray("fri") != null) {
                    agenda.setFri(Arrays.asList((Integer[]) resultSet.getArray("fri").getArray()));
                }
                if (resultSet.getArray("sat") != null) {
                    agenda.setSat(Arrays.asList((Integer[]) resultSet.getArray("sat").getArray()));
                }
                if (resultSet.getArray("sun") != null) {
                    agenda.setSun(Arrays.asList((Integer[]) resultSet.getArray("sun").getArray()));
                }
                return agenda;
            }
        });
    }

//    @Override
//    public List<Agenda> findAll() {
//        List<Agenda> output = new ArrayList<>();
//        String sql = "SELECT agenda_id, doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end"+
//                " FROM agenda;";
//        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
//        while(sqlRowSet.next()){
//            output.add(mapRowSetToAgenda(sqlRowSet));
//        }
//        return output;
//    }

    @Override
    public Agenda getAgendaByDoctorId(long doctorId) {
        return (Agenda) jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[]{doctorId}, new AgendaRowMapper());
    }
//
//    @Override
//    public List<Agenda> getAgendasByAvailabilityDay(String day) {
//        List<Agenda> output = new ArrayList<>();
//        String sql = "SELECT agenda_id, doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end" +
//                " FROM agenda";
//        switch (day.toLowerCase()) {
//            case "monday":
//                sql += " WHERE mon_start IS NOT NULL AND mon_end IS NOT NULL;";
//                break;
//            case "tues":
//                sql += " WHERE tue_start IS NOT NULL AND tue_end IS NOT NULL;";
//                break;
//            case "wednesday":
//                sql += " WHERE wen_start IS NOT NULL AND wen_end IS NOT NULL;";
//                break;
//            case "thursday":
//                sql += " WHERE thur_start IS NOT NULL AND thur_end IS NOT NULL;";
//                break;
//            case "friday":
//                sql += " WHERE fri_start IS NOT NULL AND fri_end IS NOT NULL;";
//                break;
//            case "saturday":
//                sql += " WHERE sat_start IS NOT NULL AND sat_end IS NOT NULL;";
//                break;
//            case "sunday":
//                sql += " WHERE sun_start IS NOT NULL AND sun_end IS NOT NULL;";
//                break;
//        }
//        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
//        while (sqlRowSet.next()) {
//            output.add(mapRowSetToAgenda(sqlRowSet));
//        }
//        return output;
//    }

    @Override
    public List<Integer> getUnavailableDays(long doctorId) {
        Agenda agenda = getAgendaByDoctorId(doctorId);
        List<Integer> output = new ArrayList<>();

        if (agenda.getMon() == null) {
            output.add(2);
        }
        if (agenda.getTue() == null) {
            output.add(3);
        }
        if (agenda.getWen() == null) {
            output.add(4);
        }
        if (agenda.getThur() == null) {
            output.add(5);
        }
        if (agenda.getFri() == null) {
            output.add(6);
        }
        if (agenda.getSat() == null) {
            output.add(7);
        }
        if (agenda.getSun() == null) {
            output.add(1);
        }

        return output;
    }


    @Override
    public boolean updateAgenda(Agenda agenda) {
        String sql = "UPDATE agenda"+
                " SET doctor_id = ?, mon = ?, tue = ?, wen = ?, thur = ?, fri = ?, sat = ?, sun = ?"+
                " WHERE agenda_id =?;";
        Agenda output = new Agenda();

        if (agenda.getMon() != null) {
            output.setMonArray(agenda.getMon().toArray(new Integer[agenda.getMon().size()])) ;
        }
        if (agenda.getTue() != null) {
            output.setTueArray(agenda.getTue().toArray(new Integer[agenda.getTue().size()]));
        }
        if (agenda.getWen() != null) {
            output.setWenArray(agenda.getWen().toArray(new Integer[agenda.getWen().size()]));
        }
        if (agenda.getThur() != null) {
            output.setThurArray(agenda.getThur().toArray(new Integer[agenda.getThur().size()]));
        }
        if (agenda.getFri() != null) {
            output.setFriArray(agenda.getFri().toArray(new Integer[agenda.getFri().size()]));
        }
        if (agenda.getSat() != null) {
            output.setSatArray(agenda.getSat().toArray(new Integer[agenda.getSat().size()]));
        }
        if (agenda.getSun() != null) {
            output.setSunArray(agenda.getSun().toArray(new Integer[agenda.getSun().size()]));
        }
//        return jdbcTemplate.update(sql, agenda.getDoctorId(), output.getMonArray(), output.getTueArray(), output.getWenArray(), output.getThurArray(), output.getFriArray(), output.getSatArray(), output.getSunArray(), agenda.getAgendaId()) == 1;
        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                final PreparedStatement ret = connection.prepareStatement(sql);
                ret.setLong(1, agenda.getDoctorId());
                ret.setArray(2, connection.createArrayOf("int4", output.getMonArray()));
                ret.setArray(3, connection.createArrayOf("int4", output.getTueArray()));
                ret.setArray(4, connection.createArrayOf("int4", output.getWenArray()));
                ret.setArray(5, connection.createArrayOf("int4", output.getThurArray()));
                ret.setArray(6, connection.createArrayOf("int4", output.getFriArray()));
                ret.setArray(7, connection.createArrayOf("int4", output.getSatArray()));
                ret.setArray(8, connection.createArrayOf("int4", output.getSunArray()));
                ret.setLong(9, agenda.getAgendaId());

                return ret;
            }
        }) == 1;
    }

}
//
//    @Override
//    public Agenda getAgendaById(long agendaId) {
//        Agenda output = new Agenda();
//        String sql = "SELECT agenda_id, doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end"+
//                " FROM agenda"+
//                " WHERE agenda_id = ?;";
//        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, agendaId);
//        if(sqlRowSet.next()){
//            output = mapRowSetToAgenda(sqlRowSet);
//        }
//        return output;
//    }
//
//    @Override
//    public Agenda createAgenda(Agenda agenda) {
//        String sql = "INSERT INTO agenda (doctor_id, mon_start, mon_end, tue_start, tue_end, wen_start, wen_end, thur_start, thur_end, fri_start, fri_end, sat_start, sat_end, sun_start, sun_end, lunch_start, lunch_end)" +
//                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"+
//                    " RETURNING agenda_id;";
//        long id = jdbcTemplate.queryForObject(sql, Long.class, agenda.getDoctorId(), agenda.getMonStart(), agenda.getMonEnd(), agenda.getTueStart(), agenda.getTueEnd(), agenda.getWenStart(), agenda.getWenEnd(), agenda.getThurStart(), agenda.getThurEnd(), agenda.getFriStart(), agenda.getFriEnd(), agenda.getSatStart(), agenda.getSatEnd(), agenda.getSunStart(), agenda.getSunEnd(), agenda.getLunchStart(), agenda.getLunchEnd());
//        return getAgendaById(id);
//    }
//
//    @Override
//    public boolean updateAgenda(Agenda agenda) {
//        String sql = "UPDATE agenda"+
//                " SET doctor_id = ?, mon_start = ?, mon_end = ?, tue_start = ?, tue_end = ?, wen_start = ?, wen_end = ?, thur_start = ?, thur_end = ?, fri_start = ?, fri_end = ?, sat_start = ?, sat_end = ?, sun_start = ?, sun_end = ?, lunch_start = ?, lunch_end = ?"+
//                " WHERE agenda_id =?;";
//        return jdbcTemplate.update(sql, agenda.getDoctorId(), agenda.getMonStart(), agenda.getMonEnd(), agenda.getTueStart(), agenda.getTueEnd(), agenda.getWenStart(), agenda.getWenEnd(), agenda.getThurStart(), agenda.getThurEnd(), agenda.getFriStart(), agenda.getFriEnd(), agenda.getSatStart(), agenda.getSatEnd(), agenda.getSunStart(), agenda.getSunEnd(), agenda.getLunchStart(), agenda.getLunchEnd(), agenda.getAgendaId()) == 1;
//    }
//
//    @Override
//    public boolean deleteAgenda(long agendaId) {
//        String sql = "DELETE FROM agenda" +
//                " WHERE agenda_id = ?;";
//        return jdbcTemplate.update(sql, agendaId) == 1;
//    }
//
//
//
//    private Agenda mapRowSetToAgenda(SqlRowSet sqlRowSet, long doctorId){
//        Agenda output = new Agenda();
//        output.setAgendaId(sqlRowSet.getLong("agenda_id"));
//        output.setDoctorId(sqlRowSet.getLong("doctor_id"));
//
//        if(sqlRowSet.getString("mon")!= null) {
//            String sql = "select mon from agenda where doctor_id = "
//            output.setMonStart((sqlRowSet.getTime("mon_start").toLocalTime()));
//        }
//        if(sqlRowSet.getTime("mon_end")!= null) {
//            output.setMonEnd((sqlRowSet.getTime("mon_end").toLocalTime()));
//        }
//
//        if(sqlRowSet.getTime("tue_start")!= null) {
//            output.setTueStart((sqlRowSet.getTime("tue_start").toLocalTime()));
//        }
//        if(sqlRowSet.getTime("tue_end")!= null) {
//            output.setTueEnd((sqlRowSet.getTime("tue_end").toLocalTime()));
//        }
//
//        if(sqlRowSet.getTime("wen_start")!= null) {
//            output.setWenStart((sqlRowSet.getTime("wen_start").toLocalTime()));
//        }
//        if(sqlRowSet.getTime("wen_end")!= null) {
//            output.setWenEnd((sqlRowSet.getTime("wen_end").toLocalTime()));
//        }
//
//        if(sqlRowSet.getTime("thur_start")!= null) {
//            output.setThurStart((sqlRowSet.getTime("thur_start").toLocalTime()));
//        }
//        if(sqlRowSet.getTime("thur_end")!= null) {
//            output.setThurEnd((sqlRowSet.getTime("thur_end").toLocalTime()));
//        }
//
//        if(sqlRowSet.getTime("fri_start")!= null) {
//            output.setFriStart((sqlRowSet.getTime("fri_start").toLocalTime()));
//        }
//        if(sqlRowSet.getTime("fri_end")!= null) {
//            output.setFriEnd((sqlRowSet.getTime("fri_end").toLocalTime()));
//        }
//
//        if(sqlRowSet.getTime("sat_start")!= null) {
//            output.setSatStart((sqlRowSet.getTime("sat_start").toLocalTime()));
//        }
//        if(sqlRowSet.getTime("sat_end")!= null) {
//            output.setSatEnd((sqlRowSet.getTime("sat_end").toLocalTime()));
//        }
//
//        if(sqlRowSet.getTime("sun_start")!= null) {
//            output.setSunStart((sqlRowSet.getTime("sun_start").toLocalTime()));
//        }
//        if(sqlRowSet.getTime("sun_end")!= null) {
//            output.setSunEnd((sqlRowSet.getTime("sun_end").toLocalTime()));
//        }
//
//        if(sqlRowSet.getTime("lunch_start")!= null) {
//            output.setLunchStart((sqlRowSet.getTime("lunch_start").toLocalTime()));
//        }
//        if(sqlRowSet.getTime("lunch_end")!= null) {
//            output.setLunchEnd((sqlRowSet.getTime("lunch_end").toLocalTime()));
//        }
//        return output;
//    }

//package com.techelevator.dao;
//
//        import com.techelevator.model.Agenda;
//        import org.springframework.jdbc.core.JdbcTemplate;
//        import org.springframework.jdbc.core.RowMapper;
//        import org.springframework.jdbc.support.rowset.SqlRowSet;
//        import org.springframework.stereotype.Component;
//
//        import javax.sql.DataSource;
//        import java.sql.Array;
//        import java.sql.ResultSet;
//        import java.sql.SQLException;
//        import java.util.ArrayList;
//        import java.util.Arrays;
//        import java.util.List;
//
//@Component
//public class JdbcAgendaDao implements AgendaDao {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public JdbcAgendaDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public List<Agenda> findAll() throws SQLException {
//        return jdbcTemplate.query("SELECT * FROM agenda", new RowMapper<Agenda>() {
//            @Override
//            public Agenda mapRow(ResultSet resultSet, int i) throws SQLException {
//                Agenda agenda = new Agenda();
//                agenda.setAgendaId(resultSet.getLong(1));
//                agenda.setDoctorId(resultSet.getLong(2));
//                if (resultSet.getArray("tue") != null) {
//                    agenda.setMon(Arrays.asList((Integer[]) resultSet.getArray("mon").getArray()));
//                }
//                if (resultSet.getArray("tue") != null) {
//                    agenda.setTue(Arrays.asList((Integer[]) resultSet.getArray("tue").getArray()));
//                }
//                if (resultSet.getArray("wen") != null) {
//                    agenda.setWen(Arrays.asList((Integer[]) resultSet.getArray("wen").getArray()));
//                }
//                if (resultSet.getArray("thur") != null) {
//                    agenda.setThur(Arrays.asList((Integer[]) resultSet.getArray("thur").getArray()));
//                }
//                if (resultSet.getArray("fri") != null) {
//                    agenda.setFri(Arrays.asList((Integer[]) resultSet.getArray("fri").getArray()));
//                }
//                if (resultSet.getArray("sat") != null) {
//                    agenda.setSat(Arrays.asList((Integer[]) resultSet.getArray("sat").getArray()));
//                }
//                if (resultSet.getArray("sun") != null) {
//                    agenda.setSun(Arrays.asList((Integer[]) resultSet.getArray("sun").getArray()));
//                }
//                return agenda;
//            }
//        });
//    }
//
//    //
//    @Override
//    public Agenda getAgendaByDoctorId(long doctorId) {
//        Agenda output = new Agenda();
//        String sql = "SELECT agenda_id, doctor_id, mon, tue, wen, thur, fri, sat, sun FROM agenda WHERE doctor_id = ?;";
//        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, doctorId);
//        if (sqlRowSet.next()) {
//            output = mapRowSetToAgenda(sqlRowSet);
//        }
//        return output;
//    }
//
//    private mapRowSetToAgenda(SqlRowSet sqlRowSet)
//}
////
////    @Override
////    public List<Agenda> getAgendasByAvailabilityDay(String day) {
////        List<Agenda> output = new ArrayList<>();
////        String sql = "SELECT agenda_id, doctor_id, mon, tue, wen, thur, fri, sat, sun FROM agenda ";
////        switch(day.toLowerCase()){
////            case "mon":
////                sql += "WHERE mon IS NOT NULL;";
////                break;
////            case "tue":
////                sql += "WHERE tue IS NOT NULL;";
////                break;
////            case "wen":
////                sql += "WHERE wen IS NOT NULL;";
////                break;
////            case "thur":
////                sql += "WHERE thur IS NOT NULL;";
////                break;
////            case "fri":
////                sql += "WHERE fri IS NOT NULL;";
////                break;
////            case "sat":
////                sql += "WHERE sat IS NOT NULL;";
//                break;
//            case "sun":
//                sql += "WHERE sun IS NOT NULL;";
//                break;
//        }
//        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
//        while(sqlRowSet.next()){
//            output.add(mapRowSetToAgenda(sqlRowSet));
//        }
//        return output;
//    }
//
//    @Override
//    public List<Integer> getUnavailableDays(long doctorId) {
//        //Monday = 1, Sunday = 7
//        List<Integer> output = new ArrayList<>();
//        Agenda agenda = new Agenda();
//        String sql = "SELECT agenda_id, doctor_id, mon, tue, wen, thur, fri, sat, sun FROM agenda WHERE doctor_id = ?;";
//        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
//        if(sqlRowSet.next()){
//            agenda = mapRowSetToAgenda(sqlRowSet);
//        }
//
//        if(agenda.getMon() == null){
//            output.add(1);
//        }
//        if(agenda.getTue() == null){
//            output.add(2);
//        }
//        if(agenda.getWen() == null){
//            output.add(3);
//        }
//        if(agenda.getThur() == null){
//            output.add(4);
//        }
//        if(agenda.getFri() == null){
//            output.add(5);
//        }
//        if(agenda.getSat() == null){
//            output.add(6);
//        }
//        if(agenda.getSun() == null){
//            output.add(7);
//        }
//
//        return output;
//    }
//
//    @Override
//    public Agenda getAgendaById(long agendaId) {
//        Agenda output = new Agenda();
//        String sql = "SELECT agenda_id, doctor_id, mon, tue, wen, thur, fri, sat, sun FROM agenda WHERE agenda_id = ?;";
//        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, agendaId);
//        if(sqlRowSet.next()){
//            output = mapRowSetToAgenda(sqlRowSet);
//        }
//        return output;
//    }
//
//    @Override
//    public Agenda createAgenda(Agenda agenda) {
//        String sql = "INSERT INTO agenda (doctor_id, mon, tue, wen, thur, fri, sat, sun) VALUES (?,?,?,?,?,?,?,?) RETURNING agenda_id;";
//        long agendaId = jdbcTemplate.update(sql, agenda.getDoctorId(), agenda.getMon(), agenda.getTue(), agenda.getWen(), agenda.getThur(), agenda.getFri(), agenda.getSat(), agenda.getSun());
//        agenda.setAgendaId(agendaId);
//        return agenda;
//    }
//
//    @Override
//    public boolean updateAgenda(Agenda agenda) {
//        String sql = "UPDATE agenda SET doctor_id = ?, mon = ?, tue = ?, wen = ?, thur = ?, fri = ?, sat = ?, sun = ? WHERE agenda_id = ?;";
//        return (jdbcTemplate.update(sql, agenda.getDoctorId(), agenda.getMon(), agenda.getTue(), agenda.getWen(), agenda.getThur(), agenda.getFri(), agenda.getSat(), agenda.getSun(), agenda.getAgendaId())) == 1;
//
//    }
//
//    @Override
//    public boolean deleteAgenda(long agendaId) {
//        String sql = "DELETE FROM agenda WHERE agenda_id = ?";
//        return (jdbcTemplate.update(sql, agendaId) == 1);
//    }

