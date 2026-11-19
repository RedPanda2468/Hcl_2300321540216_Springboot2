package com.example.hcltechtest.service;

import com.example.hcltechtest.dto.TaskRequest;
import com.example.hcltechtest.exception.TaskNotFoundException;
import com.example.hcltechtest.model.Task;
import com.example.hcltechtest.model.TaskStatus;
import com.example.hcltechtest.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(TaskRequest request) {
        LocalDateTime now = LocalDateTime.now();
        Task task = new Task(null, request.title(), request.description(),
                request.status() == null ? TaskStatus.TODO : request.status(), now, now);
        return repository.save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task update(Long id, TaskRequest request) {
        Task task = findById(id);
        task.setTitle(request.title());
        task.setDescription(request.description());
        if (request.status() != null) {
            task.setStatus(request.status());
        }
        task.setUpdatedAt(LocalDateTime.now());
        return repository.save(task);
    }

    public void delete(Long id) {
        if (!repository.deleteById(id)) {
            throw new TaskNotFoundException(id);
        }
    }
}
