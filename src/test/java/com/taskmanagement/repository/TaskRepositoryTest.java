package com.taskmanagement.repository;

import com.taskmanagement.model.Priority;
import com.taskmanagement.model.Status;
import com.taskmanagement.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new TaskRepository();
        taskRepository.save(new Task("1", "Task 1", "Description 1", new Date(), Priority.HIGH, Status.TODO, null));
        taskRepository.save(new Task("2", "Task 2", "Description 2", new Date(), Priority.LOW, Status.IN_PROGRESS, null));
    }

    @Test
    void whenSaveTask_thenTaskIsAdded() {
        Task task = new Task("3", "Task 3", "Description 3", new Date(), Priority.MEDIUM, Status.DONE, null);
        taskRepository.save(task);
        assertEquals(task, taskRepository.findById("3"));
    }

    @Test
    void whenFindById_thenReturnCorrectTask() {
        Task task = taskRepository.findById("1");
        assertNotNull(task);
        assertEquals("Task 1", task.getTitle());
    }

    @Test
    void whenFindAll_thenReturnAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        assertEquals(2, tasks.size());
    }

    @Test
    void whenDeleteById_thenTaskIsRemoved() {
        taskRepository.deleteById("1");
        assertNull(taskRepository.findById("1"));
    }

    @Test
    void whenFindByStatus_thenReturnTasksWithStatus() {
        List<Task> inProgressTasks = taskRepository.findByStatus(Status.IN_PROGRESS);
        assertEquals(1, inProgressTasks.size());
        assertEquals("Task 2", inProgressTasks.get(0).getTitle());
    }

    @Test
    void whenAssignTaskToUser_thenTaskIsAssigned() {
        Task task = taskRepository.findById("1");
        taskRepository.assignToUser("1", null);
        assertNull(task.getAssignedTo());
    }
}
