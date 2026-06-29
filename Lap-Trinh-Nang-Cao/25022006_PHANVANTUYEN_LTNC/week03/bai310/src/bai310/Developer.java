package bai310;

public class Developer extends Employee{
    int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateBonus() {
        return super.calculateBonus() + overtimeHours * 200000;
    }
}
