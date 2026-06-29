package bai84;

public class ParkingTicket {
    private final Vehicle vehicle;
    private final int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getHours() {
        return hours;
    }

    // Vé xe tự biết cách lấy giá tiền từ chiếc xe
    public double getFee() {
        return vehicle.calculateFee(hours);
    }

    // Vé xe tự lấy điểm thưởng
    public int getBonusPoints() {
        return vehicle.calculateBonus(hours);
    }
}
