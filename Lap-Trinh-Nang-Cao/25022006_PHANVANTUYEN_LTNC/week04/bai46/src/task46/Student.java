package task46;
public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private double gpa;
    public Student(){
        this.id = "";
        this.name = "";
        this.gpa = 0.0;
    }
    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.gpa = 0.0;
    }
    public Student(String id, String name, double gpa){
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }
    public String toString(){
        return name + " - " + id + " - " + gpa;
    }

    public int compareTo(Student otherSv){
        return Double.compare(otherSv.getGpa(), this.gpa);
    }


}
