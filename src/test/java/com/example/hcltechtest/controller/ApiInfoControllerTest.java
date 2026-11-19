package com.example.hcltechtest.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiInfoControllerTest {
    @Test
    void returnsApiNameAndTaskRoute() {
        var info = new ApiInfoController().info();
        assertEquals("HCL Task Manager API", info.get("name"));
        assertEquals("/api/tasks", info.get("tasks"));
    }
}
