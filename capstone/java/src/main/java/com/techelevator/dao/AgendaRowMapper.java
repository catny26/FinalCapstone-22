package com.techelevator.dao;

import com.techelevator.model.Agenda;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class AgendaRowMapper implements RowMapper {
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

}
