package bai67;

public abstract class NotifierDecorator implements Notifier{

    public Notifier wrap;

    public NotifierDecorator(Notifier wrap) {
        this.wrap = wrap;
    }

    @Override
    public void send(String msg) {
        if (wrap != null){
            wrap.send(msg);
        }
    }
}
