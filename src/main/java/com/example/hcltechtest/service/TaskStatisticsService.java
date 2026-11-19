package com.example.hcltechtest.service;

import com.example.hcltechtest.dto.TaskStatistics;
import com.example.hcltechtest.model.Task;
import com.example.hcltechtest.model.TaskStatus;
import com.example.hcltechtest.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStatisticsService {
    private final TaskRepository repository;

    public TaskStatisticsService(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskStatistics calculate() {
        List<Task> tasks = repository.findAll();
        long todo = tasks.stream().filter(t -> t.getStatus() == TaskStatus.TODO).count();
        long inProgress = tasks.stream().filter(t -> t.getStatus() == TaskStatus.IN_PROGRESS).count();
        long done = tasks.stream().filter(t -> t.getStatus() == TaskStatus.DONE).count();
        return new TaskStatistics(tasks.size(), todo, inProgress, done);
    }
}
