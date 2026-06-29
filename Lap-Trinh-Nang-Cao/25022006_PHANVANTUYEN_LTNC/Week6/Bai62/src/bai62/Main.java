package bai62;

public class Main {
    public static void main(String[] args) {

        // Ứng dụng quyết định dùng Email
        System.out.println("\nKhách hàng chọn nhận thông báo qua Email:");
        NotificationApp myApp1 = new EmailApp();
        myApp1.notifyUser("Đơn hàng #123 của bạn đã được giao thành công!");

        // Ứng dụng quyết định dùng SMS
        System.out.println("\nKhách hàng chọn nhận thông báo qua SMS:");
        NotificationApp myApp2 = new SmsApp();
        myApp2.notifyUser("Ma xac nhan OTP cua ban la 3636.");
    }
}
