package com.opt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptTest {
    @Test
    void testStatus() {
        assertEquals("Optimized", Main_bai6.getStatus());
    }
}