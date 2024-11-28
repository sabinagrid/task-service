package com.taskmanagement.service;

import com.taskmanagement.model.Status;
import com.taskmanagement.model.Task;
import com.taskmanagement.model.User;
import com.taskmanagement.repository.TaskRepository;

import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    public Task updateTask(Task task) {
        if (taskRepository.findById(task.getId()) == null) {
            throw new IllegalArgumentException("Task not found");
        }
        taskRepository.save(task);
        return task;
    }

    public void deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task findTaskById(String taskId) {
        Task task = taskRepository.findById(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }
        return task;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> findTasksByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }

    public void assignTaskToUser(String taskId, User user) {
        taskRepository.assignToUser(taskId, user);
    }
}
