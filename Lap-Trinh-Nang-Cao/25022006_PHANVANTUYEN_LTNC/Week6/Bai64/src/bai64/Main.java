package bai64;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("========== TEST A: ADAPTER PATTERN ==========");
        int[] numbers = {5, 2, 9, 1, 6};
        System.out.println("Mảng ban đầu: " + Arrays.toString(numbers));

        // Hệ thống chỉ biết dùng chuẩn Sorter, không hề biết LegacySorter là cái gì
        Sorter mySorter = new SorterAdapter();
        int[] sortedNumbers = mySorter.sort(numbers);

        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(sortedNumbers));


        System.out.println("\n========== TEST B: PROTOTYPE PATTERN ==========");

        // 1. Tạo bản gốc một lần duy nhất
        List<String> defaultSections = Arrays.asList("Mở đầu", "Nội dung chính", "Kết luận");
        ReportTemplate originalReport = new ReportTemplate("BÁO CÁO MẪU GỐC", "Trang {page}", defaultSections);

        // 2. Clone ra 2 bản sao và chỉ việc đổi lại cái Tiêu đề
        ReportTemplate clone1 = originalReport.clone();
        clone1.setTitle("Báo cáo Tài chính Q1/2026");

        ReportTemplate clone2 = originalReport.clone();
        clone2.setTitle("Báo cáo Nhân sự Q1/2026");

        // 3. In ra kiểm tra xem bản gốc có bị "vạ lây" không
        System.out.println("1. " + originalReport.toString());
        System.out.println("2. " + clone1.toString());
        System.out.println("3. " + clone2.toString());
    }
}
