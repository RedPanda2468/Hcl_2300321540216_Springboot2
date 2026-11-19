package com.example.hcltechtest.service;

import com.example.hcltechtest.model.Task;
import com.example.hcltechtest.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskCsvExportService {
    private final TaskRepository repository;

    public TaskCsvExportService(TaskRepository repository) {
        this.repository = repository;
    }

    public String export() {
        StringBuilder csv = new StringBuilder("id,title,description,status,createdAt,updatedAt\n");
        for (Task task : repository.findAll()) {
            csv.append(task.getId()).append(',')
                    .append(escape(task.getTitle())).append(',')
                    .append(escape(task.getDescription())).append(',')
                    .append(task.getStatus()).append(',')
                    .append(task.getCreatedAt()).append(',')
                    .append(task.getUpdatedAt()).append('\n');
        }
        return csv.toString();
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
}
