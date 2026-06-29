package bai36;

public abstract class Product {
    protected String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice(){return price;}
    public abstract double getRealPrice();
    public abstract String getName();
    public abstract String getNameProduct();
}
