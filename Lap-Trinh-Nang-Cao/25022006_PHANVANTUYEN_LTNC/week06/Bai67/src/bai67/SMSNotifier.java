package bai67;

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier wrapper) {
        super(wrapper);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("SMS Nhắn tin: " + msg);
    }
}
