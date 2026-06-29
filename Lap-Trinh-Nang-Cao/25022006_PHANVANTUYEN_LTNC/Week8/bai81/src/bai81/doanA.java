package bai81;

public class doanA {

    public static double calculateFee(String ticketType, int hours, double rate, boolean isMember) {
        double totalFee = hours * rate;
        if (isMember) {
            totalFee = totalFee * 0.9;
        }
        return totalFee;
    }

    public static void main(String[] args) {
        System.out.println("=== CHẠY THỬ ĐOẠN A: TÍNH PHÍ GỬI XE ===");

        int hours = 5;
        double rate = 5000;
        boolean isMember = true;

        double fee = calculateFee("VIP", hours, rate, isMember);
        System.out.println("Tổng tiền : " + fee + " VNĐ");
    }
}
