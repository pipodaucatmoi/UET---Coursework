import java.util.Date;

public abstract class Employee {
    String name;
    Date date;
    String nameId;

    public Employee(){}
    public Employee(String name){
        this.name = name;
    }
    public String getName(){return name;}
    public abstract double getSalary();
    public abstract String getNv();

}
