package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;

public class JdbcOfficeInfoDao implements OfficeInfoDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcOfficeInfoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public OfficeInfo getOffices() {

        return null;
    }

    @Override
    public OfficeInfo getOfficeById(long officeId) {
        return null;
    }

    @Override
    public OfficeInfo getAddress(long officeId) {
        return null;
    }

    @Override
    public OfficeInfo getPhone(long officeId) {
        return null;
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
        office.setPhone(rowSet.getString("phone_number"));
        office.setOfficeHoursOpen(rowSet.getLong("office_hours_open"));
        office.setOfficeHoursClose(rowSet.getLong("office_hours_close"));
        office.setCostPerHour(rowSet.getBigDecimal("cost_per_hour"));

        return office;
    }
}