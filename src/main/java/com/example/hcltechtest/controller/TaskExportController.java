package com.example.hcltechtest.controller;

import com.example.hcltechtest.service.TaskCsvExportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskExportController {
    private final TaskCsvExportService exportService;

    public TaskExportController(TaskCsvExportService exportService) {
        this.exportService = exportService;
    }

    @GetMapping(value = "/export", produces = "text/csv")
    public ResponseEntity<String> export() {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=tasks.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(exportService.export());
    }
}
