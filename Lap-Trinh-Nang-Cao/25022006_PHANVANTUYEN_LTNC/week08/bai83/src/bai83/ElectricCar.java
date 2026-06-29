package bai83;

public class ElectricCar extends Vehicle {
    private int batteryPercent;

    public ElectricCar(String plate, String brand) {
        super(plate, brand);
    }

    @Override
    public String getInfo() {
        return "Xe điện " + getBaseInfo();
    }

    public void charge(int percent) {
        this.batteryPercent += percent;
    }
}
