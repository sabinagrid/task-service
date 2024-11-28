package com.taskmanagement.repository;

import com.taskmanagement.model.Role;
import com.taskmanagement.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User findById(String id) {
        return users.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User findByEmail(String email) {
        return users.values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public void deleteById(String id) {
        users.remove(id);
    }

    public List<User> findByRole(Role role) {
        return users.values()
                .stream()
                .filter(user -> user.getRole() == role)
                .collect(Collectors.toList());
    }
}
