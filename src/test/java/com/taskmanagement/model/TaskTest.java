package com.taskmanagement.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void whenTaskCreated_thenPropertiesShouldBeSetCorrectly() {
        User user = new User("1", "John Doe", "john@example.com", "password123", Role.USER);
        Task task = new Task("1", "Task Title", "Task Description", new Date(), Priority.HIGH, Status.TODO, user);

        assertEquals("1", task.getId());
        assertEquals("Task Title", task.getTitle());
        assertEquals("Task Description", task.getDescription());
        assertEquals(Priority.HIGH, task.getPriority());
        assertEquals(Status.TODO, task.getStatus());
        assertEquals(user, task.getAssignedTo());
    }

    @Test
    void whenUpdateStatus_thenStatusShouldBeUpdated() {
        Task task = new Task("1", "Task Title", "Task Description", new Date(), Priority.HIGH, Status.TODO, null);
        task.updateStatus(Status.DONE);

        assertEquals(Status.DONE, task.getStatus());
    }

    @Test
    void whenAssignUser_thenTaskShouldHaveAssignedUser() {
        User user = new User("1", "John Doe", "john@example.com", "password123", Role.USER);
        Task task = new Task("1", "Task Title", "Task Description", new Date(), Priority.HIGH, Status.TODO, null);
        task.assignToUser(user);

        assertEquals(user, task.getAssignedTo());
    }
}
