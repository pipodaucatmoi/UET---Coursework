package bai71;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("task1", 1000);
        Task task2 = new Task("task2", 2000);

        Thread work1 = new Thread(task1);
        Thread work2 = new Thread(task2);

        work1.start();
        work2.start();

        try {
            work1.join();
            work2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("All tasks done");
    }
}
