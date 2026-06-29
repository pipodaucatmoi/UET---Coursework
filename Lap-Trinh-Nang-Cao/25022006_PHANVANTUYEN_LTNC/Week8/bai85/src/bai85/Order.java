package bai85;

public abstract class Order {
    protected double weight;
    protected double distance;

    public Order(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    // Ép buộc các lớp con phải tự định nghĩa logic tính phí và lấy nhãn
    public abstract double getDeliveryFee();
    public abstract String getLabel();
}
