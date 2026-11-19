package com.example.hcltechtest.service;

import com.example.hcltechtest.dto.TaskRequest;
import com.example.hcltechtest.repository.InMemoryTaskRepository;
import com.example.hcltechtest.model.TaskStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskStatisticsServiceTest {
    @Test
    void countsTasksByStatus() {
        var repository = new InMemoryTaskRepository();
        var tasks = new TaskService(repository);
        tasks.create(new TaskRequest("One", "", TaskStatus.TODO));
        tasks.create(new TaskRequest("Two", "", TaskStatus.DONE));
        tasks.create(new TaskRequest("Three", "", TaskStatus.IN_PROGRESS));

        var statistics = new TaskStatisticsService(repository).calculate();
        assertEquals(3, statistics.total());
        assertEquals(1, statistics.todo());
        assertEquals(1, statistics.done());
        assertEquals(1, statistics.inProgress());
    }
}
