package bai84;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== IN HÓA ĐƠN SAU KHI REFACTOR ======");

        ParkingCustomer customer = new ParkingCustomer("Nguyen Van A");

        customer.addTicket(new ParkingTicket(new Car("29A-111.11"), 3));     // Car: 3h
        customer.addTicket(new ParkingTicket(new Bike("30H-222.22"), 4));    // Bike: 4h
        customer.addTicket(new ParkingTicket(new Truck("29C-333.33"), 6));   // Truck: 6h

        // In kết quả
        System.out.println(customer.receipt());
    }
}
