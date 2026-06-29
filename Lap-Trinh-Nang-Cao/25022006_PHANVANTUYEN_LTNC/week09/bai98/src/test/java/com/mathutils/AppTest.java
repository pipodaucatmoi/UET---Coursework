package com.mathutils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void testAppRunning() {
        // Test đơn giản đảm bảo môi trường đã sẵn sàng
        String status = "READY";
        assertEquals("READY", status);
    }
}