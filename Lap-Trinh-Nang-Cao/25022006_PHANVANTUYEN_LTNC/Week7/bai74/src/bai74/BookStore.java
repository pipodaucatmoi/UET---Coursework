package bai74;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class BookStore {
    private Map<String, Integer> stock = new HashMap<>();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public int getStock(String title) {
        lock.readLock().lock();

        try {
            System.out.println("\nLuong "+Thread.currentThread().getName() + " đang kiểm tra sách: " + title);
            Thread.sleep(1000);
            return stock.getOrDefault(title, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addBook(String title, int qty) {
        lock.writeLock().lock();
        try {
            System.out.println("\nLuồng " + Thread.currentThread().getName() + " đang nhập " + qty + " quyển '" + title );
            Thread.sleep(1500); // Giả lập thời gian khuân vác sách vào kho

            int currentQty = stock.getOrDefault(title, 0);
            stock.put(title, currentQty + qty);

            System.out.println("\nKho hiện tại của '" + title + "' là: " + stock.get(title));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void borrow(String title, int qty) {
        lock.writeLock().lock();
        try {
            System.out.println("\nLuồng " + Thread.currentThread().getName() + " muốn mượn " + qty + " quyển '" + title );
            Thread.sleep(1500);

            int currentQty = stock.getOrDefault(title, 0);
            if (currentQty >= qty) {
                stock.put(title, currentQty - qty);
                System.out.println("\nĐã mượn thành công. Kho còn: " + stock.get(title));
            } else {
                System.out.println("\nKho không đủ sách để mượn!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
