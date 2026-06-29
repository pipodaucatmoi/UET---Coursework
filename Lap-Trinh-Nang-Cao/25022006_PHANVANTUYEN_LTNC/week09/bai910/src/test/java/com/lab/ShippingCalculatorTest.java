package com.lab;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LogTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    void testLogging() {
        logger.info("Dang chay test xac minh Logging...");
        // Logic test don gian
        assert(true);
    }
}
