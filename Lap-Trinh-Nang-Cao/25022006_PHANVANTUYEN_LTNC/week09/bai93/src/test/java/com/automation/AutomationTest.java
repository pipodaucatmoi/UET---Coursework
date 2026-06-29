package com.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AutomationTest {
    @Test
    void testSubtract() {
        // Phép toán đúng: 10 - 5 = 5
        assertEquals(5, Main_bai3.subtract(10, 5), "Phép trừ phải trả về 5");
    }
}