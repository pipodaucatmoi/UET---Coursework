package com.matrix;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PathTest {
    @Test
    void testPathCompatibility() {
        String result = Main_bai4.getSafePath("test-dir");

        // Lấy ký tự phân tách của hệ điều hành đang chạy (\ hoặc /)
        String currentOSSeparator = File.separator;

        System.out.println("Đang kiểm tra trên OS với dấu phân tách: " + currentOSSeparator);

        // Bài test sẽ pass nếu đường dẫn chứa đúng dấu của OS đó
        assertTrue(result.contains(currentOSSeparator),
                "Lỗi: Đường dẫn không tương thích với hệ điều hành hiện tại!");
    }
}