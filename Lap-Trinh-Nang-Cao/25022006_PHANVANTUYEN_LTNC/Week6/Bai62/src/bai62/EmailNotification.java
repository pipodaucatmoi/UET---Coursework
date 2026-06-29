package bai62;
public class EmailNotification implements Notification{
    @Override
    public void send(String msg){
        System.out.println("đang gửi thư : " + msg);
    }
}