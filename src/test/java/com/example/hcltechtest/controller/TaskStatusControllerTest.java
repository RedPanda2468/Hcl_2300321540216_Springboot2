package com.example.hcltechtest.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskStatusControllerTest {
    @Test
    void returnsEveryTaskStatus() {
        var statuses = new TaskStatusController().findAll();
        assertEquals(3, statuses.size());
        assertEquals("TODO", statuses.getFirst().name());
    }
}
