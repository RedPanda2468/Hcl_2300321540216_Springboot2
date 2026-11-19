package com.example.hcltechtest.service;

import com.example.hcltechtest.dto.TaskRequest;
import com.example.hcltechtest.model.TaskStatus;
import com.example.hcltechtest.repository.InMemoryTaskRepository;
import com.example.hcltechtest.validation.TaskValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskCsvExportServiceTest {
    @Test
    void exportsTasksAsCsv() {
        var repository = new InMemoryTaskRepository();
        new TaskService(repository, new TaskValidator())
                .create(new TaskRequest("Export this", "CSV example", TaskStatus.TODO));

        String csv = new TaskCsvExportService(repository).export();
        assertTrue(csv.startsWith("id,title,description,status"));
        assertTrue(csv.contains("Export this"));
    }
}
