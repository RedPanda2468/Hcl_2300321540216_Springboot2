package com.example.hcltechtest.mapper;

import com.example.hcltechtest.model.Task;
import com.example.hcltechtest.model.TaskStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskMapperTest {
    @Test
    void mapsTaskFieldsToResponse() {
        LocalDateTime now = LocalDateTime.now();
        Task task = new Task(7L, "Write tests", "JUnit", TaskStatus.TODO, now, now);
        var response = new TaskMapper().toResponse(task);
        assertEquals(7L, response.id());
        assertEquals("Write tests", response.title());
        assertEquals(TaskStatus.TODO, response.status());
    }
}
