public class PartTimeEmployee extends Employee {
    public double workingHours;
    public double hourlyRate;

    public PartTimeEmployee(String name, double workingHours, double hourlyRate){
        super(name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public double getSalary(){
        return workingHours * hourlyRate;
    }
    public String getNv() {return "Part-time";}

}
