package bai310;

public class Employee {
    String name;
    double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public double calculateBonus(){
        return 0.1 * baseSalary;
    }
    public String toString(){
        return name + " - Bonus: ";
    }
}
