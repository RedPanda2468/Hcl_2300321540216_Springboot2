package com.example.hcltechtest.dto;

import com.example.hcltechtest.model.TaskStatus;

public record TaskRequest(String title, String description, TaskStatus status) {
}
