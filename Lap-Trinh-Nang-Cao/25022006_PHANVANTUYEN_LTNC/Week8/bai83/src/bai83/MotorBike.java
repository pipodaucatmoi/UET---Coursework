package bai83;

class MotorBike extends Vehicle {
    private double fuelLevel;

    public MotorBike(String plate, String brand) {
        super(plate, brand);
    }

    @Override
    public String getInfo() {
        return "Xe máy " + getBaseInfo();
    }

    public void refuel(double liters) {
        this.fuelLevel += liters;
    }
}
