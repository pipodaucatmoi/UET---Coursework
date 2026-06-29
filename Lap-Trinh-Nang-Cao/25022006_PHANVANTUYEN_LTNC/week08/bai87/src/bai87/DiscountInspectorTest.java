package bai87;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountInspectorTest {

    @Test
    public void testEP_NegativePrice_ThrowsException() {
        // Mã TC: TC_EP_01 | Giá âm (-50.0) -> Mong đợi: Ném lỗi IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountInspector.calculateDiscount(-50.0, "MEMBER");
        });
    }

    @Test
    public void testEP_Guest_NoDiscount() {
        // Mã TC: TC_EP_02 | GUEST -> Mong đợi: 0.0 (0%)
        assertEquals(0.0, DiscountInspector.calculateDiscount(50.0, "GUEST"));
    }

    @Test
    public void testEP_Member_PriceBelow100() {
        // Mã TC: TC_EP_03 | MEMBER, price < 100 -> Mong đợi: 0.05 (5%)
        assertEquals(0.05, DiscountInspector.calculateDiscount(50.0, "MEMBER"));
    }

    @Test
    public void testEP_Vip_PriceAbove100() {
        // Mã TC: TC_EP_06 | VIP, price >= 100 -> Mong đợi: 0.20 (20%)
        assertEquals(0.20, DiscountInspector.calculateDiscount(150.0, "VIP"));
    }

    @Test
    public void testEP_InvalidMemberType_ThrowsException() {
        // Mã TC: TC_EP_07 | Thẻ vớ vẩn -> Mong đợi: Ném lỗi
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountInspector.calculateDiscount(50.0, "NORMAL");
        });
    }


    // ==============================================================
    // PHẦN 2: CODE CÁC TEST CASE THEO GIÁ TRỊ BIÊN (BVA)
    // ==============================================================

    @Test
    public void testBVA_BoundaryZero() {
        // Biên 0: min- (-0.01) -> Báo lỗi
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountInspector.calculateDiscount(-0.01, "GUEST");
        });

        // Biên 0: min (0.0) -> Hợp lệ, GUEST được 0%
        assertEquals(0.0, DiscountInspector.calculateDiscount(0.0, "GUEST"));

        // Biên 0: min+ (0.01) -> Hợp lệ, GUEST được 0%
        assertEquals(0.0, DiscountInspector.calculateDiscount(0.01, "GUEST"));
    }

    @Test
    public void testBVA_BoundaryOneHundred_WithMember() {
        // Biên 100: max- (99.99) -> Dưới 100 nên MEMBER được 5%
        assertEquals(0.05, DiscountInspector.calculateDiscount(99.99, "MEMBER"));

        // Biên 100: max (100.0) -> Từ 100 trở lên nên MEMBER được 10%
        assertEquals(0.10, DiscountInspector.calculateDiscount(100.0, "MEMBER"));

        // Biên 100: max+ (100.01) -> Từ 100 trở lên nên MEMBER được 10%
        assertEquals(0.10, DiscountInspector.calculateDiscount(100.01, "MEMBER"));
    }
}
