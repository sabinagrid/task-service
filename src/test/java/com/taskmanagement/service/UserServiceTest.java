package com.taskmanagement.service;

import com.taskmanagement.model.Role;
import com.taskmanagement.model.User;
import com.taskmanagement.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    void whenCreateUser_thenUserIsSaved() {
        User user = new User("1", "Alice", "alice@example.com", "password", Role.ADMIN);
        userService.createUser(user);
        verify(userRepository).save(user);
    }

    @Test
    void whenFindUserById_thenReturnCorrectUser() {
        User user = new User("1", "Alice", "alice@example.com", "password", Role.ADMIN);
        when(userRepository.findById("1")).thenReturn(user);
        User foundUser = userService.findUserById("1");
        assertEquals(user, foundUser);
    }

    @Test
    void whenUpdateUser_thenUserIsUpdated() {
        User existingUser = new User("1", "John Doe", "john@example.com", "password", Role.ADMIN);
        when(userRepository.findById("1")).thenReturn(existingUser);

        User updatedUser = new User("1", "John Doe Updated", "john_updated@example.com", "newpassword", Role.ADMIN);

        userService.updateUser(updatedUser);

        verify(userRepository).save(updatedUser);
    }

    @Test
    void whenDeleteUser_thenUserIsDeleted() {
        userService.deleteUser("1");
        verify(userRepository).deleteById("1");
    }

    @Test
    void whenAssignRole_thenRoleIsUpdated() {
        User existingUser = new User("1", "John Doe", "john@example.com", "password", Role.USER);
        when(userRepository.findById("1")).thenReturn(existingUser);

        userService.assignRole("1", Role.ADMIN);

        assertEquals(Role.ADMIN, existingUser.getRole());
        verify(userRepository).save(existingUser);
    }
}
