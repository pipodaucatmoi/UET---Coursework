package com.coverage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoverageTest {
    @Test
    void testCheckNumber() {
        Main_bai5 app = new Main_bai5();
        // Test bao phủ các nhánh (branches)
        assertEquals("Positive", app.checkNumber(10));
        assertEquals("Negative", app.checkNumber(-5));
        assertEquals("Zero", app.checkNumber(0));
    }
}