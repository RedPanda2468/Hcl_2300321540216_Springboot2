package com.example.hcltechtest.repository;

import com.example.hcltechtest.model.Task;
import com.example.hcltechtest.model.TaskStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskRepositoryTest {
    private final InMemoryTaskRepository repository = new InMemoryTaskRepository();

    @Test
    void savesTaskAndAssignsId() {
        LocalDateTime now = LocalDateTime.now();
        Task saved = repository.save(new Task(null, "Read docs", "", TaskStatus.TODO, now, now));
        assertNotNull(saved.getId());
        assertTrue(repository.findById(saved.getId()).isPresent());
    }

    @Test
    void deletesExistingTask() {
        LocalDateTime now = LocalDateTime.now();
        Task saved = repository.save(new Task(null, "Read docs", "", TaskStatus.TODO, now, now));
        assertTrue(repository.deleteById(saved.getId()));
        assertTrue(repository.findById(saved.getId()).isEmpty());
    }
}
