package bai62;

class SmsApp extends NotificationApp {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
