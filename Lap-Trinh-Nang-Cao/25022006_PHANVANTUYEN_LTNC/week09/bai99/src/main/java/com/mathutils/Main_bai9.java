package com.mathutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main_bai9 {
    // Khai báo Logger
    private static final Logger logger = LoggerFactory.getLogger(Main_bai9.class);

    public static void main(String[] args) {
        String version = "1.0.0";

        // Sử dụng INFO cho mốc quan trọng + Parameterized Logging {}
        logger.info("Ung dung dang khoi chay voi phien ban: {}", version);

        try {
            int result = divide(10, 0);
            logger.info("Ket qua phep chia: {}", result);
        } catch (ArithmeticException e) {
            // Sử dụng ERROR cho ngoại lệ
            logger.error("Loi toan hoc xay ra: {}", e.getMessage());
        }

        logger.info("Ung dung ket thuc.");
    }

    public static int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Khong the chia cho 0");
        return a / b;
    }
}