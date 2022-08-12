package com.techelevator.dao;

import com.techelevator.model.OfficeInfo;

import java.time.LocalTime;
import java.util.List;

public interface OfficeInfoDao {

    public List<OfficeInfo> getAllOffices();
    public OfficeInfo getOfficeById(long officeId);
    public List<OfficeInfo> getAllDoctors(long officeId);
    public List<OfficeInfo> getAllOfficesByDoctors(long doctorId);

    void updateOffice(OfficeInfo officeInfo);

    void updateUserOfficeInfo(int officeId, int userId);

    void deleteUserOfficeInfo(int officeId, int userId);

    OfficeInfo addNewOffice(OfficeInfo officeInfo);
}
