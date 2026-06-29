package bai83;

public abstract class Vehicle {
    protected String plate;
    protected String brand;

    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }

    protected String getBaseInfo() {
        return "[" + plate + "] - " + brand;
    }

    public abstract String getInfo();
}
