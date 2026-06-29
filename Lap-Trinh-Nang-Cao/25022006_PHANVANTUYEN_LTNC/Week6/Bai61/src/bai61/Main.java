package bai61;

public class Main {
    public static void main(String[] args) {

        Runnable task = () -> {
            AppConfig config = AppConfig.getInstance();
            System.out.println("Luồng [" + Thread.currentThread().getName() + "] "
                    + "đang cầm Object có HashCode: " + config.hashCode());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

    }
}
