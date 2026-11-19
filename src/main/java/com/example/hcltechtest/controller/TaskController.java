package com.example.hcltechtest.controller;

import com.example.hcltechtest.dto.TaskRequest;
import com.example.hcltechtest.dto.TaskResponse;
import com.example.hcltechtest.mapper.TaskMapper;
import com.example.hcltechtest.model.Task;
import com.example.hcltechtest.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody TaskRequest request) {
        Task task = taskService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskMapper.toResponse(task));
    }

    @GetMapping
    public List<TaskResponse> findAll() {
        return taskService.findAll().stream().map(taskMapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    public TaskResponse findById(@PathVariable Long id) {
        return taskMapper.toResponse(taskService.findById(id));
    }

    @PutMapping("/{id}")
    public TaskResponse update(@PathVariable Long id, @RequestBody TaskRequest request) {
        return taskMapper.toResponse(taskService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
