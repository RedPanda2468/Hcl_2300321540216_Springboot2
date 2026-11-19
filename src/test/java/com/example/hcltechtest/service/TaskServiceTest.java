package com.example.hcltechtest.service;

import com.example.hcltechtest.dto.TaskRequest;
import com.example.hcltechtest.exception.TaskNotFoundException;
import com.example.hcltechtest.model.TaskStatus;
import com.example.hcltechtest.repository.InMemoryTaskRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private final TaskService service = new TaskService(new InMemoryTaskRepository());

    @Test
    void createsAndFindsTask() {
        var created = service.create(new TaskRequest("Practice Java", "Collections", TaskStatus.TODO));
        assertEquals("Practice Java", service.findById(created.getId()).getTitle());
    }

    @Test
    void updatesTaskStatus() {
        var created = service.create(new TaskRequest("Practice Java", "", TaskStatus.TODO));
        var updated = service.update(created.getId(),
                new TaskRequest("Practice Java", "", TaskStatus.DONE));
        assertEquals(TaskStatus.DONE, updated.getStatus());
    }

    @Test
    void throwsWhenTaskDoesNotExist() {
        assertThrows(TaskNotFoundException.class, () -> service.findById(999L));
    }
}
