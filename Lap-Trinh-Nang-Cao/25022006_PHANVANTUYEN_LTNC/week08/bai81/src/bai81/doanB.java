package bai81;

class User {
    public String name;
    public User(String name) { this.name = name; }
}

class UserRepository {
    public User findById(int id) {
        return new User("Khách hàng #" + id);
    }
}

class UserNotificationService {
    public void sendWelcomeEmail(User user) {
        System.out.println("=> Đã gửi Email chào mừng tới: " + user.name);
    }
}

public class doanB {
    public static void main(String[] args) {
        System.out.println("=== CHẠY THỬ ĐOẠN B: QUẢN LÝ USER ===");

        UserRepository repo = new UserRepository();
        User user = repo.findById(101);

        UserNotificationService emailService = new UserNotificationService();
        emailService.sendWelcomeEmail(user);
    }
}
