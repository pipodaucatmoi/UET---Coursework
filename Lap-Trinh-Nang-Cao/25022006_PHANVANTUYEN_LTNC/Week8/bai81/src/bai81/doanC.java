package bai81;

interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private double a, b;
    public Rectangle(double a, double b) { this.a = a; this.b = b; }
    @Override public double getArea() { return a * b; }
}

class Circle implements Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    @Override public double getArea() { return Math.PI * radius * radius; }
}

public class doanC {
    public static void main(String[] args) {
        System.out.println("=== CHẠY THỬ ĐOẠN C: TÍNH DIỆN TÍCH ===");

        Shape rect = new Rectangle(4, 5);
        Shape circle = new Circle(3);

        System.out.println("Diện tích Hình chữ nhật: " + rect.getArea());
        System.out.println("Diện tích Hình tròn: " + circle.getArea());
    }
}
