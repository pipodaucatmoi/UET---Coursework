package bai74;

public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        store.addBook("Java Nâng Cao", 10);

        Runnable readTask = () -> {
            int qty = store.getStock("Java Nâng Cao");
            System.out.println("\nLuồng " + Thread.currentThread().getName() + " thấy số lượng là: " + qty);
        };
        Thread r1 = new Thread(readTask, "Reader-1");
        Thread r2 = new Thread(readTask, "Reader-2");
        Thread r3 = new Thread(readTask, "Reader-3");

        Thread w1 = new Thread(() -> store.addBook("Java Nâng Cao", 5), "Writer-NhậpSách");
        Thread w2 = new Thread(() -> store.borrow("Java Nâng Cao", 3), "Writer-MượnSách");


        r1.start();
        r2.start();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        w1.start();
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        r3.start();
        w2.start();
    }
}
