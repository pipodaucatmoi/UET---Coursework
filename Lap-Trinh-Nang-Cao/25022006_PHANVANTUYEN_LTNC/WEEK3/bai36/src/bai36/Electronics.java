package bai36;

public class Electronics extends Product {
    protected static double thueVat = 0.1;
    protected double phiBaoHanh;

    public Electronics(String name, double price, double phiBaoHanh) {
        super(name, price);
        this.phiBaoHanh = phiBaoHanh;
    }

    @Override
    public double getRealPrice() {
        return price + (price * thueVat) + phiBaoHanh;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNameProduct() {
        return "Electronics";
    }
}
