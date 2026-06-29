package bai62;
class SmsNotification implements Notification{
    @Override
    public void send(String msg){
        System.out.println("đang gửi tin nhắn : " + msg);
    }
}