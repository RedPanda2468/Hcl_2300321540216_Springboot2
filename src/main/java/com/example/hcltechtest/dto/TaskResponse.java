package com.example.hcltechtest.dto;

import com.example.hcltechtest.model.TaskStatus;
import java.time.LocalDateTime;

public record TaskResponse(Long id, String title, String description,
                           TaskStatus status, LocalDateTime createdAt,
                           LocalDateTime updatedAt) {
}
