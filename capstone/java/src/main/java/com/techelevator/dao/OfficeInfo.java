package com.techelevator.dao;

import java.math.BigDecimal;

public class OfficeInfo {

    private long officeId;
    private String officeName;
    private String address;
    private String phone;
    private long officeHoursOpen;
    private long officeHoursClose;
    private BigDecimal costPerHour;

    public OfficeInfo(long officeId, String officeName, String address, String phone, long officeHoursOpen, long officeHoursClose, BigDecimal costPerHour) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.address = address;
        this.phone = phone;
        this.officeHoursOpen = officeHoursOpen;
        this.officeHoursClose = officeHoursClose;
        this.costPerHour = costPerHour;
    }

    public OfficeInfo() {

    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String office_name) {
        this.officeName = officeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getOfficeHoursOpen() {
        return officeHoursOpen;
    }

    public void setOfficeHoursOpen(long officeHoursOpen) {
        this.officeHoursOpen = officeHoursOpen;
    }

    public long getOfficeHoursClose() {
        return officeHoursClose;
    }

    public void setOfficeHoursClose(long officeHoursClose) {
        this.officeHoursClose = officeHoursClose;
    }

    public BigDecimal getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(BigDecimal costPerHour) {
        this.costPerHour = costPerHour;
    }
}

