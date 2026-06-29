package bai62;

public abstract class NotificationApp {
    public abstract Notification createNotification();

    public void notifyUser(String msg){
        Notification notification = createNotification();
        notification.send(msg);
    }

}
