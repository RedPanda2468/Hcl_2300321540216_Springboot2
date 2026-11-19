package com.example.hcltechtest.service;

import com.example.hcltechtest.dto.TaskSearchRequest;
import com.example.hcltechtest.model.Task;
import com.example.hcltechtest.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class TaskSearchService {
    private final TaskRepository repository;

    public TaskSearchService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> search(TaskSearchRequest request) {
        return repository.findAll().stream()
                .filter(task -> request.title() == null || request.title().isBlank()
                        || task.getTitle().toLowerCase(Locale.ROOT)
                        .contains(request.title().toLowerCase(Locale.ROOT)))
                .filter(task -> request.status() == null || task.getStatus() == request.status())
                .toList();
    }
}
