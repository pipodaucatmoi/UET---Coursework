package bai84;

public abstract class Vehicle {
    protected String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public abstract double calculateFee(int hours);

    public int calculateBonus(int hours) {
        return 1;
    }
}
