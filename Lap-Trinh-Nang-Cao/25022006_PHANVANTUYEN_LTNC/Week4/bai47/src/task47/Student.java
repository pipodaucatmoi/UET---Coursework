package task47;

public class Student {
    private String id;
    private String name;
    private double gpa;
    public Student(){
        this.id = "";
        this.name = "";
        this.gpa = 0.0;
    }

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.gpa = 0.0;
    }
    public String toString(){
        return id + " " + name + " " + gpa;
    }
    public String getName(){
        return name;
    }
    public double getGpa(){
        return gpa;
    }
}
