package com.automation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main_bai3 {
    private static final Logger logger = LoggerFactory.getLogger(Main_bai3.class);

    public static void main(String[] args) {
        logger.info("--- Ứng dụng CI/CD Automation đang chạy ---");
        int a = 10;
        int b = 5;
        logger.info("Kết quả phép trừ: {} - {} = {}", a, b, subtract(a, b));
    }

    public static int subtract(int a, int b) {
        return a - b;
    }
}