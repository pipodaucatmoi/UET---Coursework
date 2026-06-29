package task43;

public abstract class Employee implements IWorkable{
    protected String id, name;
    double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public abstract double calculatePay();
    public String toString(){
        return name + " - Pay: ";
    }
}
