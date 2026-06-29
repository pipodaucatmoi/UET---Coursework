package bai86;

public class Transcript {
    private Student student;
    private Course course;
    private ScoreRecord scoreRecord;

    public Transcript(Student student, Course course, ScoreRecord scoreRecord) {
        this.student = student;
        this.course = course;
        this.scoreRecord = scoreRecord;
    }

    // Viết lại printTranscript() sao cho output KHÔNG HỀ THAY ĐỔI so với code gốc
    public void printTranscript() {
        System.out.println("Sinh viên: " + student.getName() + " (" + student.getId() + ")");
        System.out.println("Môn học: " + course.getCourseName() + " (" + course.getCourseId() + ") - " + course.getCredits() + " tín chỉ");
        System.out.println("Điểm GK: " + scoreRecord.getMidtermScore() + " | Điểm CK: " + scoreRecord.getFinalScore()
                + " | Điểm BT: " + scoreRecord.getAssignmentScore());
        System.out.printf("Điểm tổng kết: %.1f - Học lực: %s%n",
                scoreRecord.calculateFinalGrade(), scoreRecord.getAcademicStatus());
    }
}
