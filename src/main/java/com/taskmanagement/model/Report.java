package com.taskmanagement.model;

import java.util.Date;

public class Report {
    private String id;
    private String reportType;
    private String data;
    private Date generatedDate;
    private User generatedBy;

    public Report(String id, String reportType, String data, Date generatedDate, User generatedBy) {
        this.id = id;
        this.reportType = reportType;
        this.data = data;
        this.generatedDate = generatedDate;
        this.generatedBy = generatedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public User getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(User generatedBy) {
        this.generatedBy = generatedBy;
    }
}
