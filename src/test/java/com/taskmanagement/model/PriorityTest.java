package com.taskmanagement.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityTest {

    @Test
    void whenPriorityEnumUsed_thenValuesShouldMatch() {
        Priority highPriority = Priority.HIGH;
        Priority lowPriority = Priority.LOW;

        assertEquals("HIGH", highPriority.name());
        assertEquals("LOW", lowPriority.name());
    }
}
