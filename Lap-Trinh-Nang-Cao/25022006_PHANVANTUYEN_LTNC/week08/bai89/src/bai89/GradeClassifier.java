package bai89;

public class GradeClassifier {
    public static String classifyGrade(double gpa) {
        if (gpa < 0.0 || gpa > 10.0) {
            throw new IllegalArgumentException("GPA không hợp lệ: " + gpa);
        }
        // ĐÃ SỬA: <= 5.0 đổi thành < 5.0
        if (gpa < 5.0) return "Yếu";

        // ĐÃ SỬA: <= 6.5 đổi thành < 6.5
        if (gpa < 6.5) return "Trung bình";

        if (gpa < 8.0)  return "Khá";
        return "Giỏi";
    }
}
