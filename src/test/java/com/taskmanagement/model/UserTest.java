package com.taskmanagement.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void whenUserCreated_thenPropertiesShouldBeSetCorrectly() {
        User user = new User("1", "John Doe", "john@example.com", "password123", Role.ADMIN);

        assertEquals("1", user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals(Role.ADMIN, user.getRole());
    }

    @Test
    void whenAuthenticateWithCorrectPassword_thenShouldReturnTrue() {
        User user = new User("1", "John Doe", "john@example.com", "password123", Role.USER);

        assertTrue(user.authenticate("password123"));
    }

    @Test
    void whenAuthenticateWithIncorrectPassword_thenShouldReturnFalse() {
        User user = new User("1", "John Doe", "john@example.com", "password123", Role.USER);

        assertFalse(user.authenticate("wrongpassword"));
    }
}
