package com.taskmanagement.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.taskmanagement.model.*;
import com.taskmanagement.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;

class ReportServiceTest {

    private ReportService reportService;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reportService = new ReportService(taskRepository);
    }

    @Test
    void whenGenerateReportWithValidCriteria_thenReturnReport() {
        User user = new User("1", "John Doe", "john@example.com", "password", Role.ADMIN);
        List<Task> mockTasks = List.of(
                new Task("1", "Task 1", "Description 1", new Date(), Priority.HIGH, Status.DONE, user),
                new Task("2", "Task 2", "Description 2", new Date(), Priority.MEDIUM, Status.DONE, user)
        );

        when(taskRepository.getTasksByStatus(Status.DONE)).thenReturn(mockTasks);

        Report report = reportService.generateReport("DONE", user);

        assertNotNull(report);
        assertEquals("DONE", report.getReportType());
        assertEquals(user, report.getGeneratedBy());
        assertTrue(report.getData().contains("Task ID: 1"));
        assertTrue(report.getData().contains("Task ID: 2"));
    }

    @Test
    void whenGetReportDetails_thenReturnFormattedDetails() {
        User user = new User("1", "John Doe", "john@example.com", "password", Role.ADMIN);
        Report report = new Report("1", "DONE Tasks", "Report data", new Date(), user);

        String details = reportService.getReportDetails(report);

        assertNotNull(details);
        assertTrue(details.contains("DONE Tasks"));
        assertTrue(details.contains("Report data"));
        assertTrue(details.contains(user.getName()));
    }
}
