package com.example.hcltechtest.validation;

import com.example.hcltechtest.dto.TaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskValidator {
    public void validate(TaskRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Task request is required");
        }
        if (request.title() == null || request.title().isBlank()) {
            throw new IllegalArgumentException("Task title must not be blank");
        }
        if (request.title().length() > 100) {
            throw new IllegalArgumentException("Task title must be at most 100 characters");
        }
        if (request.description() != null && request.description().length() > 500) {
            throw new IllegalArgumentException("Task description must be at most 500 characters");
        }
    }
}
