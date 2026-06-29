package com.mathutils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    void testLogicBai7() {
        // Giả sử logic của bạn là kiểm tra một số có dương hay không
        int number = 10;

        // Để Pass: assertTrue(number > 0);
        // Để Fail (Kiểm chứng nút Merge bị khóa):
        assertTrue(number < 0, "Nút Merge sẽ bị khóa vì Test này bị Fail!");
    }
}