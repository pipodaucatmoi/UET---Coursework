package bai710;

public class Main {
    public static void main(String[] args) {

        Worker worker = new Worker();
        Thread thread = new Thread(worker, "NhanVien-1");

        thread.start();

        try {
            System.out.println("làm việc trong 1 giây");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.stop();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("DONE");
    }
}
