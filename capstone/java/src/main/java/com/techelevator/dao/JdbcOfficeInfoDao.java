package com.techelevator.dao;

import com.techelevator.model.OfficeInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOfficeInfoDao implements OfficeInfoDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcOfficeInfoDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<OfficeInfo> getAllOffices() {
        List<OfficeInfo> offices = new ArrayList<>();
        String sql = "SELECT * FROM office_info;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            offices.add(mapRowToOfficeInfo(results));
        }
        return offices;
    }

    @Override
    public OfficeInfo getOfficeById(long officeId) {
        OfficeInfo office = new OfficeInfo();
        String sql = "SELECT * FROM office_info WHERE office_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, officeId);
        if(result.next()) {
            office = mapRowToOfficeInfo(result);
        }
        return office;
    }

    @Override
    public List<OfficeInfo> getAllDoctors(long officeId) {
        List<OfficeInfo> doctors = new ArrayList<>();
        String sql = "SELECT * FROM users u " +
                     "JOIN users_office_info uo ON uo.user_id = u.user_id  " +
                     "WHERE uo.office_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while(results.next()) {
            doctors.add(mapRowToOfficeInfo(results));
        }
        return doctors;
    }

    @Override
    public List<OfficeInfo> getAllOfficesByDoctors(long doctorId) {
        List<OfficeInfo> offices = new ArrayList<>();
        String sql = "SELECT oi.office_id, oi.office_name, oi.address, oi.phone_number, oi.office_hours_open, oi.office_hours_close, oi.cost_per_hour "+
                "FROM office_info AS oi "+
                "JOIN users_office_info uoi ON uoi.office_id = oi.office_id "+
                "JOIN users u ON u.user_id = uoi.user_id "+
                "WHERE u.user_id =?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while(results.next()) {
            offices.add(mapRowToOfficeInfo(results));
        }
        return offices;
    }

    private OfficeInfo mapRowToOfficeInfo(SqlRowSet rowSet) {
        OfficeInfo office = new OfficeInfo();
        office.setOfficeId(rowSet.getLong("office_id"));
        office.setOfficeName(rowSet.getString("office_name"));
        office.setAddress(rowSet.getString("address"));
        office.setPhoneNumber(rowSet.getString("phone_number"));
        office.setOfficeHoursOpen(rowSet.getTime("office_hours_open").toLocalTime());
        office.setOfficeHoursClose(rowSet.getTime("office_hours_close").toLocalTime());
        office.setCostPerHour(rowSet.getBigDecimal("cost_per_hour"));

        return office;
    }
}