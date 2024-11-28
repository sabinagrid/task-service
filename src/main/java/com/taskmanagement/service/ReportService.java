package com.taskmanagement.service;

import com.taskmanagement.model.Report;
import com.taskmanagement.model.Status;
import com.taskmanagement.model.Task;
import com.taskmanagement.model.User;
import com.taskmanagement.repository.TaskRepository;

import java.util.Date;
import java.util.List;

public class ReportService {

    private final TaskRepository taskRepository;

    public ReportService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Report generateReport(String criteria, User generatedBy) {
        List<Task> tasks = taskRepository.getTasksByStatus(Status.valueOf(criteria.toUpperCase()));

        StringBuilder dataBuilder = new StringBuilder();
        for (Task task : tasks) {
            dataBuilder.append("Task ID: ").append(task.getId())
                    .append(", Title: ").append(task.getTitle())
                    .append(", Status: ").append(task.getStatus()).append("\n");
        }

        return new Report(
                "RPT-" + System.currentTimeMillis(),
                criteria,
                dataBuilder.toString(),
                new Date(),
                generatedBy
        );
    }

    public String getReportDetails(Report report) {
        return "Report ID: " + report.getId() +
                ", Type: " + report.getReportType() +
                ", Date: " + report.getGeneratedDate() +
                ", Data: " + report.getData() +
                ", Generated By: " + report.getGeneratedBy().getName();
    }
}
