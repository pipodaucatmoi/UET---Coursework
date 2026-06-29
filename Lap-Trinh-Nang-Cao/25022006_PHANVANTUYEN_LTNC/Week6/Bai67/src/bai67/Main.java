package bai67;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG GỬI THÔNG BÁO ===");
        String message = "Máy chủ của bạn đang bị quá tải!";

        System.out.println("\n--- Khách hàng 1: Chỉ thích dùng Email ---");
        Notifier client1 = new EmailNotifier();
        client1.send(message);

        System.out.println("\n--- Khách hàng 2: Dùng Email + SMS ---");
        // Bọc lõi Email bằng vỏ SMS
        Notifier client2 = new SMSNotifier(new EmailNotifier());
        client2.send(message);

        System.out.println("\n--- Khách hàng 3: Combo Email + Facebook + SMS (Trùm cuối) ---");
        // Cách viết "Búp bê Nga": Gói dần từ trong ra ngoài
        Notifier client3 = new EmailNotifier();           // Lõi trong cùng
        client3 = new FacebookNotifier(client3);          // Bọc lớp Facebook ra ngoài Email
        client3 = new SMSNotifier(client3);               // Bọc tiếp lớp SMS ra ngoài cùng

        // Khi gọi send, nó sẽ gọi xuyên thấu vào trong rồi bung dần ra ngoài
        client3.send(message);
    }
}
