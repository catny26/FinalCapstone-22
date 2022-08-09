package com.techelevator.dao;

import com.techelevator.model.OfficeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

public class JdbcOfficeInfoDaoTest extends BaseDaoTests {

    private static final OfficeInfo OFFICE_1 =
            new OfficeInfo(1, "Cardiology Consultants of Philadelphia", "207 N Broad St, Philadelphia, PA 19107", "2152273627", LocalTime.parse("08:00"), LocalTime.parse("16:00"), BigDecimal.valueOf(50.00));

    private static final OfficeInfo OFFICE_2 =
            new OfficeInfo(2, "Philadelphia Family Medicine", "1028 W Oregon Ave, Philadelphia, PA 19148", "2153897766", LocalTime.parse("09:00"), LocalTime.parse("18:00"), BigDecimal.valueOf(60.00));

    private static final OfficeInfo OFFICE_3 =
            new OfficeInfo(3, "Ninth Street Internal Medicine", "805 Locust St, Philadelphia, PA 19107", "2154408681", LocalTime.parse("07:30"), LocalTime.parse("17:00"), BigDecimal.valueOf(80.00));

    private static final OfficeInfo OFFICE_4 =
            new OfficeInfo(4, "Philadelphia Dentistry", "1601 Walnut St #1302, Philadelphia, PA 19102", "2155686222", LocalTime.parse("08:00"), LocalTime.parse("17:00"), BigDecimal.valueOf(70.00));

    private JdbcOfficeInfoDao sut;

    private OfficeInfo testOffice;

    @Before
    public void setup() {
        sut = new JdbcOfficeInfoDao((JdbcTemplate) dataSource);
        testOffice = new OfficeInfo(99, "Test Office", "123 Main Street, Hereville, HA 12345", "2155551234", LocalTime.now(), LocalTime.now(), BigDecimal.valueOf(0.00));
    }

    @Test
    public void getAllOffices_returns_list_of_all_offices() {
        List<OfficeInfo> offices = sut.getAllOffices();
        Assert.assertEquals(4, offices.size());
    }

    @Test
    public void getOfficeById_returns_correct_office_for_id() {
        OfficeInfo office = sut.getOfficeById(1);
        assertOfficesMatch("Incorrect ID entered.", OFFICE_1, office);

        office = sut.getOfficeById(2);
        assertOfficesMatch("Incorrect ID entered.", OFFICE_2, office);
    }

    @Test
    public void getAllDoctors_returns_list_of_all_doctors() {
        List<OfficeInfo> doctors = sut.getAllDoctors(3);
        Assert.assertEquals(4, doctors.size());

        doctors = sut.getAllDoctors(4);
        Assert.assertEquals(5, doctors.size());
    }

    @Test
    public void getAllDoctors_returns_empty_list_for_id_not_found() {
        List<OfficeInfo> doctors = sut.getAllDoctors(99);
        Assert.assertEquals("Office ID not found.", 0, doctors.size());
    }

    private void assertOfficesMatch(String message, OfficeInfo expected, OfficeInfo actual) {
        Assert.assertEquals(message, expected.getOfficeId(), actual.getOfficeId());
        Assert.assertEquals(message, expected.getOfficeName(), actual.getOfficeName());
        Assert.assertEquals(message, expected.getAddress(), actual.getAddress());
        Assert.assertEquals(message, expected.getPhoneNumber(), actual.getPhoneNumber());
        Assert.assertEquals(message, expected.getOfficeHoursOpen(), actual.getOfficeHoursOpen());
        Assert.assertEquals(message, expected.getOfficeHoursClose(), actual.getOfficeHoursClose());
        Assert.assertEquals(message, expected.getCostPerHour(), actual.getCostPerHour());
    }
}
