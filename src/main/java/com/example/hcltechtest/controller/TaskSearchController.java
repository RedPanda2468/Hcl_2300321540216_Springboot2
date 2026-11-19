package com.example.hcltechtest.controller;

import com.example.hcltechtest.dto.TaskResponse;
import com.example.hcltechtest.dto.TaskSearchRequest;
import com.example.hcltechtest.mapper.TaskMapper;
import com.example.hcltechtest.service.TaskSearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskSearchController {
    private final TaskSearchService searchService;
    private final TaskMapper mapper;

    public TaskSearchController(TaskSearchService searchService, TaskMapper mapper) {
        this.searchService = searchService;
        this.mapper = mapper;
    }

    @GetMapping("/search")
    public List<TaskResponse> search(@RequestParam(required = false) String title,
                                     @RequestParam(required = false) com.example.hcltechtest.model.TaskStatus status) {
        return searchService.search(new TaskSearchRequest(title, status))
                .stream().map(mapper::toResponse).toList();
    }
}
