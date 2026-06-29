package bai83;

public class Car extends Vehicle {
    private double fuelLevel;

    public Car(String plate, String brand) {
        super(plate, brand);
    }

    @Override
    public String getInfo() {
        return "Ô tô " + getBaseInfo();
    }

    public void refuel(double liters) {
        this.fuelLevel += liters;
    }
}
