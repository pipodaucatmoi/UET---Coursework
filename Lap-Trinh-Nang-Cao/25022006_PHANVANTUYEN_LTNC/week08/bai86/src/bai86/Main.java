package bai86;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo Sinh viên
        Student student = new Student("SE12345", "Nguyen Van IT", 3.2);

        // 2. Tạo Môn học
        Course course = new Course("PRJ301", "Advanced Programming", 3);

        // 3. Tạo Bảng điểm số
        ScoreRecord scores = new ScoreRecord(8.0, 9.0, 10.0);

        // 4. Lắp ráp lại thành một Bảng điểm hoàn chỉnh và In ra
        Transcript transcript = new Transcript(student, course, scores);

        System.out.println("====== BẢNG ĐIỂM SAU KHI REFACTOR ======\n");
        transcript.printTranscript();
    }
}
