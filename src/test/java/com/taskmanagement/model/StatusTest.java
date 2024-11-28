package com.taskmanagement.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    @Test
    void whenStatusEnumUsed_thenValuesShouldMatch() {
        Status todoStatus = Status.TODO;
        Status doneStatus = Status.DONE;

        assertEquals("TODO", todoStatus.name());
        assertEquals("DONE", doneStatus.name());
    }
}
