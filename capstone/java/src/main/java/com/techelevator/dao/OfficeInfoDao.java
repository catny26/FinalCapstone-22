package com.techelevator.dao;

import java.math.BigDecimal;

public interface OfficeInfoDao {

    OfficeInfo getOffices();
    OfficeInfo getOfficeById(long officeId);
    OfficeInfo getAddress(long officeId);
    OfficeInfo getPhone(long officeId);
    public long getOfficeHours();
    public String getDoctors();
    public String getDoctorById(long doctorId);
    public BigDecimal getCostPerHour(long doctorId);


}
