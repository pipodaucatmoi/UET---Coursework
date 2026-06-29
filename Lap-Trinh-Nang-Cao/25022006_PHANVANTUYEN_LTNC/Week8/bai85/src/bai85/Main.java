package bai85;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== HỆ THỐNG TÍNH PHÍ GIAO HÀNG ======\n");

        List<Order> orders = new ArrayList<>();
        orders.add(new StandardOrder(2.5, 10));  // weight: 2.5kg, distance: 10km
        orders.add(new ExpressOrder(1.0, 5));    // weight: 1.0kg, distance: 5km
        orders.add(new FragileOrder(3.0, 20));   // weight: 3.0kg, distance: 20km
        orders.add(new BulkyOrder(50.0, 100));   // weight: 50.0kg, distance: 100km

        int count = 1;
        double totalRevenue = 0;

        for (Order order : orders) {
            System.out.println("Đơn hàng #" + count++);
            System.out.println("Phân loại: " + order.getLabel());
            System.out.println("Phí vận chuyển: " + String.format("%,.0f", order.getDeliveryFee()) + " VNĐ");
            System.out.println("------------------------------------");

            totalRevenue += order.getDeliveryFee();
        }

        System.out.println("TỔNG DOANH THU: " + String.format("%,.0f", totalRevenue) + " VNĐ");
    }
}
