package bai55;
import java.util.*;

public class Main {

    // CÁCH 1: DÙNG ARRAYLIST
    public static void testArrayList(List<Book> data) {
        System.out.println("\n1. TEST ARRAYLIST (Lưu lộn xộn, tìm chậm)");
        List<Book> list = new ArrayList<>(data); // Thêm sách

        String searchId = "B03";
        for (Book b : list) {
            if (b.getId().equals(searchId)) {
                System.out.println("-> Đã tìm thấy: " + b);
                break;
            }
        }

        list.removeIf(b -> b.getId().equals("B02"));
        System.out.println("-> Đã xóa B02. In danh sách:");
        list.forEach(b -> System.out.println("   " + b));
    }

    // CÁCH 2: DÙNG HASHMAP
    public static void testHashMap(List<Book> data) {
        System.out.println("\n 2. TEST HASHMAP (Lưu lộn xộn, tìm siêu nhanh)");
        Map<String, Book> map = new HashMap<>();
        for (Book b : data) map.put(b.getId(), b);

        System.out.println("-> Đã tìm thấy: " + map.get("B03"));

        map.remove("B02");
        System.out.println("-> Đã xóa B02. In danh sách:");
        map.values().forEach(b -> System.out.println("   " + b));
    }

    // CÁCH 3: DÙNG TREEMAP
    public static void testTreeMap(List<Book> data) {
        System.out.println("\n 3. TEST TREEMAP (Tự động sắp xếp A-Z theo ID)");
        Map<String, Book> treeMap = new TreeMap<>();
        for (Book b : data) treeMap.put(b.getId(), b);

        System.out.println("-> Đã tìm thấy: " + treeMap.get("B03"));

        treeMap.remove("B02");
        System.out.println("-> Đã xóa B02. In danh sách (Bạn sẽ thấy ID được xếp từ B01->B05):");
        treeMap.values().forEach(b -> System.out.println("   " + b));
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("B05", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 1941),
                new Book("B01", "Số Đỏ", "Vũ Trọng Phụng", 1936),
                new Book("B04", "Tắt Đèn", "Ngô Tất Tố", 1939),
                new Book("B02", "Chí Phèo", "Nam Cao", 1941),
                new Book("B03", "Lão Hạc", "Nam Cao", 1943)
        );

        testArrayList(books);
        testHashMap(books);
        testTreeMap(books);
    }
}
