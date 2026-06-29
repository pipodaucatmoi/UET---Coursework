package bai67;

class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier wrapper) {
        super(wrapper);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("FB Ping tin nhắn: " + msg);
    }
}
