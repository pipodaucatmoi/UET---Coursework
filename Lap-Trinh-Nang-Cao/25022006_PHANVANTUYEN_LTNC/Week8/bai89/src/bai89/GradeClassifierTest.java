package bai89;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeClassifierTest {

    @Test
    public void testEP_Yeu() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(3.0));
    }

    @Test
    public void testEP_TrungBinh() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.0));
    }

    @Test
    public void testEP_Kha() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.0));
    }

    @Test
    public void testEP_Gioi() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(9.0));
    }

    @Test
    public void testBVA_Boundary_0() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.0));
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.1));
    }

    @Test
    public void testBVA_Boundary_5() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(4.9));
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0)); // Test từng bị Fail
    }

    @Test
    public void testBVA_Boundary_6_5() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.4));
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5)); // Test từng bị Fail
    }

    @Test
    public void testBVA_Boundary_8() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.9));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
    }

    @Test
    public void testBVA_Boundary_10() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }

    @Test
    public void testException_NegativeGPA() {
        // Test biên dưới -0.1
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(-0.1);
        });
        assertEquals("GPA không hợp lệ: -0.1", exception.getMessage());
    }

    @Test
    public void testException_OverGPA() {
        // Test biên trên 10.1
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(10.1);
        });
        assertEquals("GPA không hợp lệ: 10.1", exception.getMessage());
    }
}