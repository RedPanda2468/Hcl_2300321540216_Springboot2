package com.example.hcltechtest.repository;

import com.example.hcltechtest.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    boolean deleteById(Long id);
}
