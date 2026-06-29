package com.matrix;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main_bai4 {
    private static final Logger logger = LoggerFactory.getLogger(Main_bai4.class);

    /**
     * Cách viết SAI (Cố tình gây lỗi đa hệ điều hành):
     * return "target\\" + folder; -> Chỉ chạy trên Windows
     * return "target/" + folder; -> Chỉ chạy trên Linux/Mac
     */

    // Cách viết ĐÚNG (Refactor): Dùng Paths.get để tự thích ứng OS
    public static String getSafePath(String... segments) {
        Path path = Paths.get("target", segments);
        return path.toString();
    }

    public static void main(String[] args) {
        String myPath = getSafePath("data", "logs");
        logger.info("Đường dẫn an toàn trên OS này là: {}", myPath);
    }
}