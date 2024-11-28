package com.taskmanagement.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    @Test
    void whenReportCreated_thenPropertiesShouldBeSetCorrectly() {
        User user = new User("1", "Admin User", "admin@example.com", "password123", Role.ADMIN);
        Report report = new Report("1", "Monthly", "Report Data", new Date(), user);

        assertEquals("1", report.getId());
        assertEquals("Monthly", report.getReportType());
        assertNotNull(report.getGeneratedDate());
        assertEquals("Report Data", report.getData());
        assertEquals(user, report.getGeneratedBy());
    }

    @Test
    void whenSetData_thenDataShouldBeUpdated() {
        Report report = new Report("1", "Monthly", "Initial Data", new Date(), null);
        report.setData("Updated Data");

        assertEquals("Updated Data", report.getData());
    }

    @Test
    void whenSetGeneratedBy_thenGeneratedByShouldBeUpdated() {
        Report report = new Report("1", "Monthly", "Report Data", new Date(), null);
        User admin = new User("1", "Admin User", "admin@example.com", "password123", Role.ADMIN);
        report.setGeneratedBy(admin);

        assertEquals(admin, report.getGeneratedBy());
    }
}
