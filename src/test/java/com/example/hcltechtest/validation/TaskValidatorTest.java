package com.example.hcltechtest.validation;

import com.example.hcltechtest.dto.TaskRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskValidatorTest {
    private final TaskValidator validator = new TaskValidator();

    @Test
    void acceptsValidTitle() {
        assertDoesNotThrow(() -> validator.validate(new TaskRequest("Learn Spring", "Study beans", null)));
    }

    @Test
    void rejectsBlankTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(new TaskRequest("  ", null, null)));
    }

    @Test
    void rejectsLongTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(new TaskRequest("x".repeat(101), null, null)));
    }
}
