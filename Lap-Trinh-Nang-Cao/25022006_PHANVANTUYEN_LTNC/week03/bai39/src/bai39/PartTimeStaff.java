package bai39;

public class PartTimeStaff extends Staff{
    int workingHours;
    double hourlyRate;

    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getTypeClass() {
        return "bai39.PartTimeStaff";
    }

    @Override
    public double getPaymentAmount() {
        return workingHours * hourlyRate;
    }
}
