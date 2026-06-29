package bai79;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread[] threads = new Thread[4];

        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    counter.increment();
                    //counter.incrementWithTryLock();
                }
            }, "Thread-" + i);

            threads[i].start();
        }

        for (int i = 0; i < 4; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nFINAL COUNTER : " + counter.getValue());
    }
}
