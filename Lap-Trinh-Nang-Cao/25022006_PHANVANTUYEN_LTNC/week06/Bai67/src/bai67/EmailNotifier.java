package bai67;

public class EmailNotifier implements Notifier{
    @Override
    public void send(String msg) {
        System.out.println("Gửi  thu : " + msg);
    }
}
