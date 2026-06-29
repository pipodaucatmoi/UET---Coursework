package com.mathutils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.cfg.Configuration;

public class Main_bai1 {
    private static final Logger logger = LoggerFactory.getLogger(Main_bai1.class);

    public static void main(String[] args) {
        logger.info("--- Ứng dụng MathUtils (Bài 1) đã chạy thành công! ---");

        int a = 20, b = 30;
        logger.info("Kết quả phép tính: {} + {} = {}", a, b, add(a, b));

        try {
            Configuration cfg = new Configuration().configure();
            logger.info("Hibernate 6 đã được nạp cấu hình.");
        } catch (Exception e) {
            logger.warn("Hibernate đang chạy ở chế độ quét log (chưa có DB).");
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
