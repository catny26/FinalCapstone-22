package com.techelevator.dao;

import java.math.BigDecimal;
import java.util.List;

public interface OfficeInfoDao {

    List<OfficeInfo> getOffices();
    OfficeInfo getOfficeById(long officeId);
    OfficeInfo getAddress(long officeId);
    OfficeInfo getPhoneNumber(long officeId);
    public long getOfficeHours();
    public String getDoctors();
    public String getDoctorById(long doctorId);
    public BigDecimal getCostPerHour(long doctorId);


}
