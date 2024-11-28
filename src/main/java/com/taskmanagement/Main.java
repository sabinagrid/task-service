package com.taskmanagement;

import com.taskmanagement.model.*;
import com.taskmanagement.repository.TaskRepository;
import com.taskmanagement.repository.UserRepository;
import com.taskmanagement.service.ReportService;
import com.taskmanagement.service.TaskService;
import com.taskmanagement.service.UserService;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        TaskRepository taskRepository = new TaskRepository();
        UserRepository userRepository = new UserRepository();

        UserService userService = new UserService(userRepository);
        TaskService taskService = new TaskService(taskRepository);
        ReportService reportService = new ReportService(taskRepository);

        User admin = new User("1", "Admin User", "admin@example.com", "password123", Role.ADMIN);
        User manager = new User("2", "Manager User", "manager@example.com", "password123", Role.MANAGER);
        User user = new User("3", "Regular User", "user@example.com", "password123", Role.USER);

        userService.createUser(admin);
        userService.createUser(manager);
        userService.createUser(user);

        System.out.println("Users created:");
        userService.findAllUsers().forEach(u -> System.out.println(" - " + u.getName()));

        Task task1 = new Task("1", "Task 1", "First task", new Date(), Priority.HIGH, Status.TODO, manager);
        Task task2 = new Task("2", "Task 2", "Second task", new Date(), Priority.MEDIUM, Status.TODO, user);

        taskService.createTask(task1);
        taskService.createTask(task2);

        System.out.println("\nTasks created:");
        taskService.findAllTasks().forEach(t -> System.out.println(" - " + t.getTitle()));

        System.out.println("\nAssigning Task 1 to User...");
        taskService.assignTaskToUser("1", user);
        System.out.println("Task 1 assigned to: " + taskService.findTaskById("1").getAssignedTo().getName());

        System.out.println("\nUpdating Task 1 status to IN_PROGRESS...");
        taskService.updateTask(new Task("1", "Task 1", "First task", new Date(), Priority.HIGH, Status.IN_PROGRESS, user));
        System.out.println("Task 1 status: " + taskService.findTaskById("1").getStatus());

        System.out.println("\nGenerating report for tasks with status TODO...");
        Report report = reportService.generateReport("TODO", admin);
        System.out.println("\nReport Details:");
        System.out.println(reportService.getReportDetails(report));
    }
}
