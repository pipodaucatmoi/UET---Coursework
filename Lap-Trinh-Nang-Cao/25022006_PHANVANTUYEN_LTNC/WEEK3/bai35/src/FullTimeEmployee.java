public class FullTimeEmployee extends Employee{
    public double baseSalary;
    public double bonus;
    public double penalty;

    public FullTimeEmployee(String name, double baseSalary, double bonus, double penalty) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }
    public double getSalary() {
        return baseSalary + (bonus - penalty);
    }
    public String getNv(){
        return "Full-time";
    }
}
