package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcOfficeInfoDao implements OfficeInfoDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcOfficeInfoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<OfficeInfo> getOffices() {
        List<OfficeInfo> offices = new ArrayList<>();
        String sql = "SELECT * FROM office_info;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, offices);
        while(results.next()) {
            offices.add(mapRowToOfficeInfo(results));
        }
        return offices;
    }

    @Override
    public OfficeInfo getOfficeById(long officeId) {
        OfficeInfo office = null;
        String sql = "SELECT * FROM office_info WHERE office_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, officeId);
        if(result.next()) {
            office = mapRowToOfficeInfo(result);
        }
        return office;
    }

    @Override
    public OfficeInfo getAddress(long officeId) {
        OfficeInfo address = null;
        String sql = "SELECT office_address FROM office_info WHERE office_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, officeId);
        if(result.next()) {
            address = mapRowToOfficeInfo(result);
        }
        return address;
    }

    @Override
    public OfficeInfo getPhoneNumber(long officeId) {
        OfficeInfo phoneNumber = null;
        String sql = "SELECT phone_number FROM office_id WHERE office_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, officeId);
        if(result.next()) {
            phoneNumber = mapRowToOfficeInfo(result);
        }
        return phoneNumber;
    }

    @Override
    public long getOfficeHours() {
        return 0;
    }

    @Override
    public String getDoctors() {
        return null;
    }

    @Override
    public String getDoctorById(long doctorId) {
        return null;
    }

    @Override
    public BigDecimal getCostPerHour(long doctorId) {
        return null;
    }

    private OfficeInfo mapRowToOfficeInfo(SqlRowSet rowSet) {
        OfficeInfo office = new OfficeInfo();
        office.setOfficeId(rowSet.getLong("office_id"));
        office.setOfficeName(rowSet.getString("office_name"));
        office.setAddress(rowSet.getString("address"));
        office.setPhoneNumber(rowSet.getString("phone_number"));
        office.setOfficeHoursOpen(rowSet.getLong("office_hours_open"));
        office.setOfficeHoursClose(rowSet.getLong("office_hours_close"));
        office.setCostPerHour(rowSet.getBigDecimal("cost_per_hour"));

        return office;
    }
}