package com.example.hcltechtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiInfoController {
    @GetMapping("/api")
    public Map<String, String> info() {
        return Map.of(
                "name", "HCL Task Manager API",
                "version", "1.0",
                "tasks", "/api/tasks"
        );
    }
}
