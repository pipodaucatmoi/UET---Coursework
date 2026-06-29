package bai88;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    // Chạy ĐÚNG 1 LẦN trước khi tất cả các test case bắt đầu
    @BeforeAll
    public static void setUpAll() {
        System.out.println("=== Bắt đầu chạy MathUtilsTest ===");
    }

    // Chạy ĐÚNG 1 LẦN sau khi tất cả các test case đã chạy xong
    @AfterAll
    public static void tearDownAll() {
        System.out.println("=== Kết thúc ===");
    }

    // ==========================================
    // TEST CASE CHO HÀM max(a, b)
    // ==========================================

    @Test
    public void testMax_AGreaterThanB() {
        assertEquals(5, MathUtils.max(5, 3));
    }

    @Test
    public void testMax_AEqualsB() {
        assertEquals(4, MathUtils.max(4, 4));
    }

    @Test
    public void testMax_ALessThanB() {
        assertEquals(10, MathUtils.max(2, 10));
    }

    @Test
    public void testMax_BoundaryValues() {
        // Kiểm tra cực đại
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0));
        // Kiểm tra cực tiểu
        assertEquals(0, MathUtils.max(Integer.MIN_VALUE, 0));
        // So sánh 2 thái cực
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    // ==========================================
    // TEST CASE CHO HÀM divide(a, b)
    // ==========================================

    @Test
    public void testDivide_BGreaterThanZero() {
        assertEquals(2, MathUtils.divide(10, 5));
    }

    @Test
    public void testDivide_BLessThanZero() {
        assertEquals(-5, MathUtils.divide(10, -2));
    }

    @Test
    public void testDivide_BEqualsZero_ThrowsException() {
        // Dùng assertThrows để bắt ngoại lệ
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.divide(10, 0);
        });

        // Kiểm tra luôn xem câu thông báo lỗi có đúng như thiết kế không
        assertEquals("Divider must not be zero", exception.getMessage());
    }
}
