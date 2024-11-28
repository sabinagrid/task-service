package com.taskmanagement.model;

import java.util.Date;

public class Task {
    private String id;
    private String title;
    private String description;
    private Date dueDate;
    private Priority priority;
    private Status status;
    private User assignedTo;

    public Task(String id, String title, String description, Date dueDate, Priority priority, Status status, User assignedTo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void updateStatus(Status newStatus) {
        this.status = newStatus;
    }

    public void assignToUser(User user) {
        this.assignedTo = user;
    }

    public void markAsCompleted() {
        this.status = Status.DONE;
    }
}
