package com.taskmanagement.service;

import com.taskmanagement.model.*;
import com.taskmanagement.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    private TaskService taskService;
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
    }

    @Test
    void whenCreateTask_thenTaskIsSaved() {
        Task task = new Task("1", "Task 1", "Description 1", new Date(), Priority.HIGH, Status.TODO, null);
        taskService.createTask(task);
        verify(taskRepository).save(task);
    }

    @Test
    void whenFindTaskById_thenReturnCorrectTask() {
        Task task = new Task("1", "Task 1", "Description 1", new Date(), Priority.HIGH, Status.TODO, null);
        when(taskRepository.findById("1")).thenReturn(task);
        Task foundTask = taskService.findTaskById("1");
        assertEquals(task, foundTask);
    }

    @Test
    void whenUpdateTask_thenTaskIsUpdated() {
        Task existingTask = new Task("1", "Task 1", "Description", new Date(), Priority.HIGH, Status.TODO, null);
        when(taskRepository.findById("1")).thenReturn(existingTask);

        Task updatedTask = new Task("1", "Task 1 Updated", "Updated Description", new Date(), Priority.LOW, Status.IN_PROGRESS, null);

        taskService.updateTask(updatedTask);

        verify(taskRepository).save(updatedTask);
    }

    @Test
    void whenDeleteTask_thenTaskIsDeleted() {
        taskService.deleteTask("1");
        verify(taskRepository).deleteById("1");
    }

    @Test
    void whenAssignTaskToUser_thenTaskIsAssigned() {
        User user = new User("2", "Bob", "bob@example.com", "password", Role.USER);
        taskService.assignTaskToUser("1", user);
        verify(taskRepository).assignToUser("1", user);
    }
}
