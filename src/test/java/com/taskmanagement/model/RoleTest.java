package com.taskmanagement.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void whenRoleEnumUsed_thenValuesShouldMatch() {
        Role adminRole = Role.ADMIN;
        Role userRole = Role.USER;

        assertEquals("ADMIN", adminRole.name());
        assertEquals("USER", userRole.name());
    }
}
