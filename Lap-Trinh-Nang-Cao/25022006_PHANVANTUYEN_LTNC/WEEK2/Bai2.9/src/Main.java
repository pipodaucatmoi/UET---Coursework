import java.util.Scanner;
class Product{
    private String name;
    private double price;
    private int quantity;
    private double discount;
    private static double taxRate = 0.1;
    private static double totalRevenue = 0;
    public Product(String name, double price, int quantity, double discount){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }
    public static void updateTaxRate(double newRate){
        taxRate = newRate;
    }
    public double calculateFinalPrice(){
        return (price - discount) * (1 + taxRate);
    }
    public void updateDiscount(double newDiscount){
        this.discount = newDiscount;
    }
    public void sell(int amount){
        if (amount <= quantity){
            this.quantity = this.quantity - amount;
            double tien = amount * calculateFinalPrice();
            totalRevenue = totalRevenue + tien;
            System.out.println("ban thanh cong " + amount + name + " thu duoc " + tien );
        } else {
            System.err.println("Khong du hang trong kho");
        }
    }
    public static double showMoney(){
        return totalRevenue;
    }

}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap Product p1, p2");
        Product p1 = new Product(sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextDouble());
        Product p2 = new Product(sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextDouble());
        System.out.println("so luong muon mua p1");
        p1.sell(sc.nextInt());
        System.out.println("so luong muon mua p2");
        p2.sell(sc.nextInt());
        System.out.println("gia p1 p2");
        System.out.println(p1.calculateFinalPrice());
        System.out.println(p2.calculateFinalPrice());
        Product.updateTaxRate(0.08);
        System.out.println("gia p1 p2 sau khi giam thue");
        System.out.println(p1.calculateFinalPrice());
        System.out.println(p2.calculateFinalPrice());
        p1.updateDiscount(10);
        System.out.println("gia p1 p2 cuoi cung");
        System.out.println(p1.calculateFinalPrice());
        System.out.println(p2.calculateFinalPrice());
        System.out.println("TONG DOANH THU");
        System.out.println(Product.showMoney());

    }
}