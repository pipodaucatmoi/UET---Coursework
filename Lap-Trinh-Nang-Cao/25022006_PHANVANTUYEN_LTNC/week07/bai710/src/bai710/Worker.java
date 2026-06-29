package bai710;

public class Worker implements Runnable{
    private volatile boolean running = true;

    public void stop(){ this.running = false; }

    @Override
    public void run() {
        System.out.println();
        while (running) {
            System.out.println("Working...");

            try { Thread.sleep(200); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println("END");
    }
}
