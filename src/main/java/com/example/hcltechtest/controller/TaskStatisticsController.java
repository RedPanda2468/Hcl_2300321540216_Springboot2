package com.example.hcltechtest.controller;

import com.example.hcltechtest.dto.TaskStatistics;
import com.example.hcltechtest.service.TaskStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskStatisticsController {
    private final TaskStatisticsService statisticsService;

    public TaskStatisticsController(TaskStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public TaskStatistics statistics() {
        return statisticsService.calculate();
    }
}
