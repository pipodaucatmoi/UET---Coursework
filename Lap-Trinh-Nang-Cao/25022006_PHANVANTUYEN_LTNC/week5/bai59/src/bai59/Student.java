package bai59;
import java.io.Serializable;

public class Student implements Serializable {
    String id;
    String name;
    double gpa;

    private static final long serialVersionUID = 1L;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String toString(){
        return "ID: " + id + " - Tên: " + name +  " - GPA: " + gpa;
    }
}
