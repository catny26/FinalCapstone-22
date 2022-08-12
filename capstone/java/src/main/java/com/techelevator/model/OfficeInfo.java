package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Objects;

public class OfficeInfo {

    private long officeId;
    private String officeName;
    private String address;
    private String phoneNumber;
    private LocalTime officeHoursOpen;
    private LocalTime officeHoursClose;
    private BigDecimal costPerHour;

    public OfficeInfo(long officeId, String officeName, String address, String phoneNumber, LocalTime officeHoursOpen, LocalTime officeHoursClose, BigDecimal costPerHour) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
        this.officeName = office_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalTime getOfficeHoursOpen() {
        return officeHoursOpen;
    }

    public void setOfficeHoursOpen(LocalTime officeHoursOpen) {
        this.officeHoursOpen = officeHoursOpen;
    }

    public LocalTime getOfficeHoursClose() {
        return officeHoursClose;
    }

    public void setOfficeHoursClose(LocalTime officeHoursClose) {
        this.officeHoursClose = officeHoursClose;
    }

    public BigDecimal getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(BigDecimal costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficeInfo that = (OfficeInfo) o;
        return officeId == that.officeId && Objects.equals(officeName, that.officeName) && Objects.equals(address, that.address) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(officeHoursOpen, that.officeHoursOpen) && Objects.equals(officeHoursClose, that.officeHoursClose) && Objects.equals(costPerHour, that.costPerHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeId, officeName, address, phoneNumber, officeHoursOpen, officeHoursClose, costPerHour);
    }
}

