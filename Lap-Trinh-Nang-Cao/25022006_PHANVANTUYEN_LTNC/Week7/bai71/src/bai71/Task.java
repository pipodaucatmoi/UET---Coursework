package bai71;

public class Task implements Runnable{
    public String name;
    public long durationMs;

    public Task(String name, long durationMs) {
        this.durationMs = durationMs;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Start : " + name);

        try {
            Thread.sleep(durationMs);
        } catch (InterruptedException e){
            System.out.println(name + " wake-up đột ngột");
        }

        System.out.println("End : " + name);
    }
}
