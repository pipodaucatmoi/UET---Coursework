package bai84;

public class Truck extends Vehicle {

    public Truck(String plate) {
        super(plate);
    }

    @Override
    public double calculateFee(int hours) {
        return 15 + hours * 4;
    }

    @Override
    public int calculateBonus(int hours) {
        return (hours > 5) ? 2 : 1; // Khách VIP gửi lâu được 2 điểm
    }
}
