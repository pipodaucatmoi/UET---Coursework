package bai36;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Product[] ds1 = new Product[n];
        for (int i = 0; i < n; i++){
            String sp = sc.nextLine();
            String[] chia = sp.split("\"");
            String oneKey = chia[0].trim();
            String name = chia[1];
            String[] chia2 = chia[2].trim().split("\\s+");
            double price = Double.parseDouble(chia2[0]);
            if (oneKey.equals("E")){
                double phiBaoHanh = Double.parseDouble(chia2[1]);
                ds1[i] = new Electronics(name, price, phiBaoHanh);
            } else {
                LocalDate hetHan = LocalDate.parse(chia2[1]);
                ds1[i] = new Food(name, price, hetHan, today);
            }
        }
        double total = 0;
        for (int i = 0; i < n; i++){
            total = total + ds1[i].getRealPrice();
            System.out.println(ds1[i].getName() + " - " + ds1[i].getNameProduct() + " - " + ds1[i].getRealPrice());
        }
        System.out.println("Total = " + total);
    }
}
