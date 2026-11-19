package com.example.hcltechtest.mapper;

import com.example.hcltechtest.dto.TaskResponse;
import com.example.hcltechtest.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskResponse toResponse(Task task) {
        return new TaskResponse(task.getId(), task.getTitle(), task.getDescription(),
                task.getStatus(), task.getCreatedAt(), task.getUpdatedAt());
    }
}
