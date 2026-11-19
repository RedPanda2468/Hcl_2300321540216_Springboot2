package com.example.hcltechtest.dto;

import com.example.hcltechtest.model.TaskStatus;

public record TaskSearchRequest(String title, TaskStatus status) {
}
