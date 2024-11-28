package com.taskmanagement.service;

import com.taskmanagement.model.Role;
import com.taskmanagement.model.User;
import com.taskmanagement.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User updateUser(User user) {
        if (userRepository.findById(user.getId()) == null) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.save(user);
        return user;
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public User findUserById(String userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return user;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return user;
    }

    public void assignRole(String userId, Role role) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        user.setRole(role);
        userRepository.save(user);
    }

    public List<User> findUsersByRole(Role role) {
        return userRepository.findByRole(role);
    }
}
