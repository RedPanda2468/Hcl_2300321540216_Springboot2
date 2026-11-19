package com.example.hcltechtest.controller;

import com.example.hcltechtest.dto.TaskStatusOption;
import com.example.hcltechtest.model.TaskStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/task-statuses")
public class TaskStatusController {
    @GetMapping
    public List<TaskStatusOption> findAll() {
        return Arrays.stream(TaskStatus.values())
                .map(status -> new TaskStatusOption(status.name(), description(status)))
                .toList();
    }

    private String description(TaskStatus status) {
        return switch (status) {
            case TODO -> "Task has not been started";
            case IN_PROGRESS -> "Task is currently being worked on";
            case DONE -> "Task has been completed";
        };
    }
}
