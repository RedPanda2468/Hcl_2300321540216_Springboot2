package com.example.hcltechtest.service;

import com.example.hcltechtest.dto.TaskRequest;
import com.example.hcltechtest.dto.TaskSearchRequest;
import com.example.hcltechtest.model.TaskStatus;
import com.example.hcltechtest.repository.InMemoryTaskRepository;
import com.example.hcltechtest.validation.TaskValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskSearchServiceTest {
    @Test
    void searchesByTitleAndStatus() {
        var repository = new InMemoryTaskRepository();
        var taskService = new TaskService(repository, new TaskValidator());
        taskService.create(new TaskRequest("Learn Spring", "", TaskStatus.TODO));
        taskService.create(new TaskRequest("Learn Java", "", TaskStatus.DONE));

        var results = new TaskSearchService(repository)
                .search(new TaskSearchRequest("spring", TaskStatus.TODO));
        assertEquals(1, results.size());
        assertEquals("Learn Spring", results.getFirst().getTitle());
    }
}
