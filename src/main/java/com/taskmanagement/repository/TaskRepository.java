package com.taskmanagement.repository;

import com.taskmanagement.model.Status;
import com.taskmanagement.model.Task;
import com.taskmanagement.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class TaskRepository {
    private final Map<String, Task> tasks = new HashMap<>();

    public void save(Task task) {
        tasks.put(task.getId(), task);
    }

    public Task findById(String id) {
        return tasks.get(id);
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public List<Task> findByStatus(Status status) {
        return tasks.values()
                .stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }

    public void deleteById(String id) {
        tasks.remove(id);
    }

    public void assignToUser(String taskId, User user) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.assignToUser(user);
        }
    }

    public List<Task> getTasksByStatus(Status status) {
        return tasks.values().stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
