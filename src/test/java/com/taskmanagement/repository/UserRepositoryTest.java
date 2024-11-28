package com.taskmanagement.repository;

import com.taskmanagement.model.Role;
import com.taskmanagement.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userRepository.save(new User("1", "Alice", "alice@example.com", "password", Role.ADMIN));
        userRepository.save(new User("2", "Bob", "bob@example.com", "password", Role.MANAGER));
    }

    @Test
    void whenSaveUser_thenUserIsAdded() {
        User user = new User("3", "Charlie", "charlie@example.com", "password", Role.USER);
        userRepository.save(user);
        assertEquals(user, userRepository.findById("3"));
    }

    @Test
    void whenFindById_thenReturnCorrectUser() {
        User user = userRepository.findById("1");
        assertNotNull(user);
        assertEquals("Alice", user.getName());
    }

    @Test
    void whenFindByEmail_thenReturnCorrectUser() {
        User user = userRepository.findByEmail("bob@example.com");
        assertNotNull(user);
        assertEquals("Bob", user.getName());
    }

    @Test
    void whenFindAll_thenReturnAllUsers() {
        List<User> users = userRepository.findAll();
        assertEquals(2, users.size());
    }

    @Test
    void whenDeleteById_thenUserIsRemoved() {
        userRepository.deleteById("1");
        assertNull(userRepository.findById("1"));
    }

    @Test
    void whenFindByRole_thenReturnUsersWithRole() {
        List<User> managers = userRepository.findByRole(Role.MANAGER);
        assertEquals(1, managers.size());
        assertEquals("Bob", managers.get(0).getName());
    }
}
